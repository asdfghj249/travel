package com.service.impl;

import com.dao.UserMapper;
import com.pojo.User;
import com.pojo.UserExample;
import com.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User checkUser(String username, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(example);
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public User getById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
