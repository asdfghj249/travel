package com.service;

import com.pojo.User;

import java.util.List;

public interface IUserService {

    public void save(User user);

    public User login(User user);
}
