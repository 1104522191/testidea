package com.test.controller;

import com.sun.deploy.net.HttpResponse;
import com.test.model.User;
import com.test.service.IUserService;
import com.test.service.impl.UserServiceImpl;
import com.test.util.JsonResponseBody;
import com.test.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    public JsonResponseBody login(HttpServletResponse resp, User u){
//        JsonResponseBody login = userService.login(u);
//        Map<String,Object> claims=new HashMap<>();
//        claims.put("user",login.getData());
//        String jwt = JwtUtils.createJwt(claims, 1000 * 60);
//        resp.setHeader("jwt",jwt );
        return userService.login(u);
    }

    @RequestMapping("/register")
    public JsonResponseBody register(User u){
        return userService.insertSelective(u);
    }
}
