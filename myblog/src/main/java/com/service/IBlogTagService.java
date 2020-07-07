package com.service;

import com.pojo.Blog;
import com.pojo.BlogTags;
import com.pojo.Tag;
import com.pojo.Type;

import java.util.List;

public interface IBlogTagService  {

    //根据blog_id查询
    List<BlogTags> getByBolgId(Long id);

    //根据tag_id查询
    List<BlogTags> getByTid(Long id);

    //多表查询
    List<Blog> getBlogByTid(Long id);

    //根据tag_id查询 blog
    List<Blog> getByTagId(Long id);

    //根据blog_id查询 tag
    List<Tag> getByBId(Long id);

    //增加
    void save(BlogTags blogTags);

    //删除
    void deleteByBlogId(Long id);
}
