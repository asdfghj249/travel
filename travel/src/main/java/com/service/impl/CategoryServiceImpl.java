package com.service.impl;

import com.dao.CategoryMapper;
import com.dao.RouteMapper;
import com.pojo.Category;
import com.pojo.CategoryExample;
import com.pojo.Route;
import com.service.ICategoryService;
import com.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryMapper categoryMapper;


    @Override
    public List<Category> findAll() {
        CategoryExample example = new CategoryExample();
        example.setOrderByClause("cid asc");
        List<Category> categories = categoryMapper.selectByExample(example);
        return categories;
    }

    @Override
    public Category findOne(int cid) {
        return categoryMapper.selectByPrimaryKey(cid);
    }


}
