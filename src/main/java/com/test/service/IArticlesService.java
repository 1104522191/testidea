package com.test.service;

import com.test.model.Articles;
import com.test.util.PageBean;

import java.util.List;

public interface IArticlesService {
    int deleteByPrimaryKey(Integer id);

    int insert(Articles record);

    int insertSelective(Articles record);

    Articles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Articles record);

    int updateByPrimaryKeyWithBLOBs(Articles record);

    int updateByPrimaryKey(Articles record);

    List<Articles> queryByPage(Articles articles, PageBean pageBean);
}
