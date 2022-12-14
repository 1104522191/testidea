package com.test.controller;

import com.test.model.Articles;
import com.test.service.IArticlesService;
import com.test.service.impl.ArticlesServiceImpl;
import com.test.util.JsonResponseBody;
import com.test.util.JsonResponseStatus;
import com.test.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/articles")
public class ArticlesController {
    @Autowired
    private IArticlesService articlesService;

    @RequestMapping("/query")
    public JsonResponseBody queryByPage(Articles articles, PageBean pageBean){
        List<Articles> a= articlesService.queryByPage(articles,pageBean);
        if(a!=null&&a.size()>0){
            return new JsonResponseBody(a,(long) pageBean.getTotal());
        }else{
            return  new JsonResponseBody(JsonResponseStatus.QUERYBYPAGEFAILE.getCode(),JsonResponseStatus.QUERYBYPAGEFAILE.getMsg());
        }
    }

    @RequestMapping("/add")
    public JsonResponseBody add(Articles articles){
        int n = articlesService.insertSelective(articles);
        if(n>0){
            return new JsonResponseBody();
        }else{
            return new JsonResponseBody(JsonResponseStatus.ADDERROR.getCode(),JsonResponseStatus.ADDERROR.getMsg());
        }
    }

    @RequestMapping("/delete")
    public JsonResponseBody delete(Integer id){
        int n = articlesService.deleteByPrimaryKey(id);
        if(n>0){
            return new JsonResponseBody();
        }else{
            return new JsonResponseBody(JsonResponseStatus.DELETERROR.getCode(),JsonResponseStatus.DELETERROR.getMsg());
        }
    }
}
