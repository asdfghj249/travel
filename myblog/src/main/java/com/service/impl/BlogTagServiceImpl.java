package com.service.impl;

import com.dao.BlogMapper;
import com.dao.BlogTagsMapper;
import com.dao.TagMapper;
import com.dao.TypeMapper;
import com.pojo.*;
import com.service.IBlogTagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlogTagServiceImpl implements IBlogTagService {

    @Resource
    private BlogTagsMapper blogTagsMapper;
    @Resource
    private BlogMapper blogMapper;
    @Resource
    private TagMapper tagMapper;

    @Override
    public List<BlogTags> getByBolgId(Long id) {
        BlogTagsExample example = new BlogTagsExample();
        example.createCriteria().andBlog_idEqualTo(String.valueOf(id));
        return blogTagsMapper.selectByExample(example);
    }

    @Override
    public List<BlogTags> getByTid(Long id) {
        BlogTagsExample example = new BlogTagsExample();
        example.createCriteria().andTag_idEqualTo(id);
        return blogTagsMapper.selectByExample(example);
    }

    @Override
    public List<Blog> getBlogByTid(Long id) {
        return blogTagsMapper.getBlogsByTid(id);
    }

    @Override
    public List<Blog> getByTagId(Long id) {
        BlogTagsExample example = new BlogTagsExample();
        example.createCriteria().andTag_idEqualTo(id);
        List<BlogTags> blogTags = blogTagsMapper.selectByExample(example);
        List<Blog> list = new ArrayList<>();
        for (BlogTags bt : blogTags) {
            Blog blog = blogMapper.selectByPrimaryKey(Long.valueOf(bt.getBlog_id()));
            list.add(blog);
        }
        return list;
    }

    @Override
    public List<Tag> getByBId(Long id) {
        BlogTagsExample example = new BlogTagsExample();
        example.createCriteria().andBlog_idEqualTo(String.valueOf(id));
        List<BlogTags> blogTags = blogTagsMapper.selectByExample(example);
        List<Tag> list = new ArrayList<>();
        for (BlogTags bt : blogTags) {
            Tag tag = tagMapper.selectByPrimaryKey(bt.getTag_id());
            list.add(tag);
        }
        return list;
    }

    @Override
    public void save(BlogTags blogTags) {
        blogTagsMapper.insert(blogTags);
    }

    @Override
    public void deleteByBlogId(Long id) {
        BlogTagsExample example = new BlogTagsExample();
        example.createCriteria().andBlog_idEqualTo(String.valueOf(id));
        blogTagsMapper.deleteByExample(example);
    }

}
