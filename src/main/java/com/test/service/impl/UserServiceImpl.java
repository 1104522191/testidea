package com.test.service.impl;

import com.test.mapper.UserMapper;
import com.test.model.User;
import com.test.service.IUserService;
import com.test.util.JsonResponseBody;
import com.test.util.JsonResponseStatus;
import com.test.util.MD5;
import com.test.util.MyStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer uid) {
        return 0;
    }

    @Override
    public int insert(User record) {
        return 0;
    }

    @Override
    public JsonResponseBody insertSelective(User record) {
        MD5 md5 = new MD5();
        String md5ofStr = md5.getMD5ofStr(record.getUpwd());
        record.setUpwd(md5ofStr);
        int n = userMapper.insertSelective(record);
        if(n>0){
            return new JsonResponseBody();
        }else {
            return new JsonResponseBody(JsonResponseStatus.ERROR.getCode(),JsonResponseStatus.ERROR.getMsg());
        }
    }

    @Override
    public User selectByPrimaryKey(Integer uid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }

    @Override
    public JsonResponseBody login(User user) {
        User login = userMapper.login(user);
        if(login==null){
            return new JsonResponseBody(MyStatus.NULLACCOUNT.getCode(),MyStatus.NULLACCOUNT.getMsg());
        }else {
            if(user.getUpwd().equals(login.getUpwd())){
                return new JsonResponseBody(login);
            }else {
                return new JsonResponseBody(JsonResponseStatus.PWDERROR.getCode(),JsonResponseStatus.PWDERROR.getMsg());
            }
        }
    }
}
