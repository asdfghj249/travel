package com.service;

import com.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface IBlogService {

    //查询所有blog
    List<Blog> getAllBlogs();

    List<Blog> getAllBlogs1();

    //根据id查询
    Blog getBlogById(Long id);

    //编辑器转换为html
    Blog getAndConvert(Long id);

    //增
    void saveBlog(Blog blog);

    //改
    void  updateBlog(Blog blog);

    //删
    void  deleteBlog(Long id);

    //根据条件查询
    List<Blog> searchBlogs(String title,String typeId,String recommed);

    List<Blog> search(String query);

    Map<String,List<Blog>> getArchiveBlog();

    Integer getCountBlogs();


    //根据type_id查询
    List<Blog> getByTypeId(Long id);

    //按更新时间查询五条blog用于首页
    List<Blog> getFiveBlog();
}
