package com.service;

import com.pojo.User;

public interface IUserService {

    //登录判断
    User checkUser(String username,String password);

    //根据id查询
    User getById(Long id);
}
