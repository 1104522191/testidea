package com.test.service;

import com.test.model.User;
import com.test.util.JsonResponseBody;
import org.springframework.transaction.annotation.Transactional;

public interface IUserService {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);


    JsonResponseBody  insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    JsonResponseBody login(User user);
}
