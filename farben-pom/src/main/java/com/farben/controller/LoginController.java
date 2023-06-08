package com.farben.controller;

import com.farben.entity.JsonResult;
import com.farben.service.UserService;
import com.farben.utils.aop.WebLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@Slf4j
@RestController
@RequestMapping("/farben")
public class LoginController extends BaseController{

    //将Service注入Web层
    @Resource
    UserService userService;

    @WebLog(channel = "web", name = "用户登录", action = "/loginIn", saveFlag = true)
    @PostMapping(value = "/loginIn")
    public JsonResult<?> login(@RequestBody String jsonString){
        return renderSuccess(userService.loginIn(jsonString));
    }

    @WebLog(channel = "web", name = "用户新增", action = "/register", saveFlag = true)
    //实现注册功能
    @PostMapping(value = "/register")
    public String signUp(String name,String password){
        userService.Insert(name, password);
        return "success";
    }
}