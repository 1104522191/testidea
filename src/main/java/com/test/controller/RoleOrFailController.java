package com.test.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoleOrFailController {

    @RequestMapping("/abc")
    public String unFail(){
        return  "unauthorized";
    }
}
