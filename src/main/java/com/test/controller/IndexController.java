package com.test.controller;


import com.mysql.cj.Session;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/index")
public class IndexController {


    @RequestMapping("tologin")
    public String tologin(){
        return "login";
    }

    @RequestMapping("dologin")
    public String dologin(String username, String password, HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            System.out.println("身份验证失败");
            session.setAttribute("message","身份验证失败");
            return "login";
        }
        session.setAttribute("username",username);
        return "main";
    }

    @RequestMapping("/updateU")
    @RequiresRoles("admin")
    public String updateUser(){
        return "admin/updateUser";
    }
}
