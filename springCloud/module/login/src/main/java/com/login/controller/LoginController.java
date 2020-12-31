package com.login.controller;

import com.common.utils.RestResult;
import com.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/loginApi",method = {RequestMethod.POST})
    public RestResult login(){
        return loginService.login();
    }

    @RequestMapping(value = "/loginsApi",method = {RequestMethod.POST})
    public RestResult logins(){
        return loginService.logins();
    }

}
