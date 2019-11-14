package site.waconde.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * shiro配置类 三大件：Realm,securityManager,shiroFilter
 *
 * @author side.wang
 * @since 2019年11月1日
 */
@Configuration
public class ShiroConfig {
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/doLogin.do");
        shiroFilterFactoryBean.setUnauthorizedUrl("/permissionDenied.do");
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // <!-- authc:所有url都必须认证通过才可以访问；anon:所有url都可以匿名访问；user:登录后或者Remember Me可访问-->
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/image/**", "anon");
        filterChainDefinitionMap.put("/jquery/**", "anon");
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/doLogin.do", "anon");
        filterChainDefinitionMap.put("/permissionDenied.do", "anon");
        filterChainDefinitionMap.put("/doLoginUI.do", "anon");
        filterChainDefinitionMap.put("/doLogout.do", "logout");

        // 主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截 剩余的都需要认证
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;

    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        defaultSecurityManager.setRealm(customRealm());
        return defaultSecurityManager;
    }

    @Bean
    public RealmConfg customRealm() {
        RealmConfg customRealm = new RealmConfg();
        return customRealm;
    }

    /* 
     * 启用shiro在ioc容器中的注解，但是必须配置在Spring Ioc容器中Shiro bean的生成周期方法。依托LifecycleBeanPostProcessor
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor =
            new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /*
     * LifecycleBeanPostProcessor可以自动调用在Spring Ioc窗口中 Shiro bean的生成周期方法，
     * 负责org.apache.shiro.util.Initializable类型bean的初始化和销毁。
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
}
