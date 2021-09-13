package site.waconde.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import site.waconde.dao.PermissionMapper;
import site.waconde.dao.RoleMapper;
import site.waconde.dao.RolePermissionMapper;
import site.waconde.dao.StudentLoginMapper;
import site.waconde.dao.StudentRoleMapper;
import site.waconde.entity.PermissionInfo;
import site.waconde.entity.RoleInfo;
import site.waconde.entity.RolePermissionInfo;
import site.waconde.entity.StudentInfo;
import site.waconde.entity.StudentRoleInfo;

/**
 * 自定义Realm
 *
 * @author side.wang
 * @since 2019年11月1日
 */
@Configuration
public class RealmConfg extends AuthorizingRealm {
    @Autowired
    private StudentLoginMapper studentLoginMapper;
    @Autowired
    private StudentRoleMapper studentRoleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        StudentInfo student = (StudentInfo) principals.getPrimaryPrincipal();
        // 查询用户的角色
        QueryWrapper<StudentRoleInfo> studentRoleQuery = new QueryWrapper<StudentRoleInfo>();
        studentRoleQuery.eq("student_id", student.getId());
        List<StudentRoleInfo> studentRoleList = studentRoleMapper.selectList(studentRoleQuery);
        if (studentRoleList == null || studentRoleList.size() == 0) {throw new AuthorizationException("此账号目前不属于任何角色");}
        List<Integer> roleIds = new ArrayList<Integer>(studentRoleList.size());
        for (StudentRoleInfo studentRoleInfo : studentRoleList) {roleIds.add(studentRoleInfo.getRoleId());}
        List<RoleInfo> roles = roleMapper.selectBatchIds(roleIds);
        // 查询角色的权限
        List<RolePermissionInfo> rolePermissionList = rolePermissionMapper.selectBatchIds(roleIds);
        if (rolePermissionList == null || rolePermissionList.size() == 0) {
            throw new AuthorizationException("此角色目前无任何权限");
        }
        List<Integer> permissionIds = new ArrayList<Integer>(rolePermissionList.size());
        for (RolePermissionInfo rolePermissionInfo : rolePermissionList) {
            permissionIds.add(rolePermissionInfo.getPermissionId());
        }
        List<PermissionInfo> permissions = permissionMapper.selectBatchIds(permissionIds);
        Set<String> permissionSet = new HashSet<>();
        Set<String> roleSet = new HashSet<>();
        for (RoleInfo role : roles) {
            if (! StringUtils.isEmpty(role.getName())) {
                roleSet.add(role.getName());
            }
        }
        for (PermissionInfo permission : permissions) {
            if (! StringUtils.isEmpty(permission.getName())) {
                permissionSet.add(permission.getName());
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roleSet);
        info.setStringPermissions(permissionSet);
        return info;
    }

    /**
     * 身份认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("-------身份认证方法--------");
        String username = (String) token.getPrincipal();
        String pwd = new String((char[]) token.getCredentials());
        QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<StudentInfo>();
        queryWrapper.eq("name", username);
        StudentInfo studentInfo = studentLoginMapper.selectOne(queryWrapper);
        if (studentInfo == null) {
            throw new UnknownAccountException("用户名不存在");
        } else if (studentInfo.getDeleted() == 1) {
            throw new LockedAccountException("账户已锁定");
        }
        return new SimpleAuthenticationInfo(studentInfo, studentInfo.getPwd(), getName());
    }

    /**
     * 凭证匹配器
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(1);
        super.setCredentialsMatcher(hashedCredentialsMatcher);
    }
}
