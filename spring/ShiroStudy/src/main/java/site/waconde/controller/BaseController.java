package site.waconde.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import site.waconde.entity.StudentInfo;

@Controller
@RequestMapping("/")
public class BaseController {
    @GetMapping("doLoginUI.do")
    public String login(StudentInfo student) {
        return "login";
    }

    @RequiresPermissions("all")
    @RequiresRoles("admin")
    @GetMapping("permissionDenied.do")
    public String permissionDenied() {
        return "permissiondenied";
    }
}
