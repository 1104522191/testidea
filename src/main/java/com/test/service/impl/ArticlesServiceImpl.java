package com.test.service.impl;

import com.test.mapper.ArticlesMapper;
import com.test.model.Articles;
import com.test.service.IArticlesService;
import com.test.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlesServiceImpl implements IArticlesService {
    @Autowired
    private ArticlesMapper articlesMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return articlesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Articles record) {
        return 0;
    }

    @Override
    public int insertSelective(Articles record) {
        return articlesMapper.insertSelective(record);
    }

    @Override
    public Articles selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Articles record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Articles record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Articles record) {
        return 0;
    }

    @Override
    public List<Articles> queryByPage(Articles articles, PageBean pageBean) {
        return articlesMapper.queryByPage(articles);
    }
}
