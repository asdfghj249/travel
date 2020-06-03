package com.service;

import com.pojo.Category;
import com.pojo.Route;

import java.util.List;

public interface ICategoryService {

    public List<Category> findAll();

    public Category findOne(int cid);
}
