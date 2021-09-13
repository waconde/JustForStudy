package site.waconde.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class StudentLoginController {
    // 登陆url必须在shiro配置中允许匿名访问
    @PostMapping("doLogin.do")
    public String login(String name, String pwd) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken upToken = new UsernamePasswordToken(name, pwd);
        try {
            subject.login(upToken);
        } catch (IncorrectCredentialsException e) {
            return "密码错误";
        }
        return "login successfully";
    }
}
