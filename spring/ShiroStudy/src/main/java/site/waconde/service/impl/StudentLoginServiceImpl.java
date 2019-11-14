package site.waconde.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import site.waconde.dao.StudentLoginMapper;
import site.waconde.entity.StudentInfo;
import site.waconde.service.StudentLoginService;
import site.waconde.utils.Md5ProduceUtil;

@Service
public class StudentLoginServiceImpl implements StudentLoginService {

    @Autowired
    private StudentLoginMapper studentLoginMapper;

    @Override
    public String login(StudentInfo student) {
        Assert.hasText(student.getPwd(), "请先输入密码！");
        String inputPassword = Md5ProduceUtil.encrypte(student.getPwd());
        QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<StudentInfo>();
        queryWrapper.eq("name", student.getName());
        StudentInfo origin = studentLoginMapper.selectOne(queryWrapper);
        Assert.isNull(origin, "此用户名尚未注册");

        if (inputPassword.equals(origin.getPwd())) {
            return "Celebration!";
        }
        return "密码错误";
    }

}
