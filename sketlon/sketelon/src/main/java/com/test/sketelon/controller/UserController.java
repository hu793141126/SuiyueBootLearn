package com.test.sketelon.controller;

import com.test.base.aop.ControllerLog;
import com.test.base.bean.WebResult;
import com.test.base.constants.enums.Module;
import com.test.sketelon.bean.User;
import com.test.sketelon.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController  {
    @Resource
    UserService userService;
    @ControllerLog(module = Module.USER,logDesc = "user.test")
    @GetMapping("/test")
    public WebResult insertUser() {
        User user=new User();
        user.setPassword("12312");
        user.setUsername("asdasdasd");
        WebResult webResult=new WebResult();
        webResult.setCode(0);
        return webResult;
    }
}
