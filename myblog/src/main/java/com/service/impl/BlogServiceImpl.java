package com.service.impl;

import com.NotFoundException;
import com.dao.BlogMapper;
import com.pojo.Blog;
import com.pojo.BlogExample;
import com.service.IBlogService;
import com.util.MarkdownUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements IBlogService {

    @Resource
    private BlogMapper blogMapper;

    @Override
    public List<Blog> getAllBlogs() {
        BlogExample example = new BlogExample();
        example.setOrderByClause("update_time DESC");
        return blogMapper.selectByExample(example);
    }

    @Override
    public List<Blog> getAllBlogs1() {
        return blogMapper.selectByExample(null);
    }

    @Override
    public Blog getBlogById(Long id) {
        return blogMapper.selectByPrimaryKey(id);
    }

    @Override
    public Blog getAndConvert(Long id) {
        Blog blog = blogMapper.selectByPrimaryKey(id);
        Blog b = new Blog();
        BeanUtils.copyProperties(blog, b);
        String content = b.getContent();
        b.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        blogMapper.updateViews(id);
        return b;
    }

    @Override
    public void saveBlog(Blog blog) {
        blog.setCreate_time(new Date());
        blog.setUpdate_time(new Date());
        blog.setViews(0);
        blogMapper.insertSelective(blog);
    }

    @Override
    public void updateBlog(Blog blog) {
        if (blog.getAppreciation()==null){
            blog.setAppreciation(0);
        }
        if (blog.getCommentabled()==null){
            blog.setCommentabled(0);
        }
        if (blog.getShare_statement()==null){
            blog.setShare_statement(0);
        }
        if (blog.getRecommend()==null){
            blog.setRecommend(0);
        }
        Blog blog1 = blogMapper.selectByPrimaryKey(blog.getId());
        if (blog1 == null) {
            throw new NotFoundException("该博客不存在");
        }
        BeanUtils.copyProperties(blog, blog1);
        blog1.setUpdate_time(new Date());
        blogMapper.updateByPrimaryKey(blog1);
    }

    @Override
    public void deleteBlog(Long id) {
        blogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Blog> searchBlogs(String title, String typeId, String recommed) {
        BlogExample example = new BlogExample();
        BlogExample.Criteria criteria = example.createCriteria();
        if (title != null) criteria.andTitleLike("%" + title + "%");
        if (!"0".equals(typeId)) criteria.andType_idEqualTo(Long.valueOf(typeId));
        if (recommed == null){
            recommed = "0";
            criteria.andRecommendEqualTo(Integer.valueOf(recommed));
        }else {
            criteria.andRecommendEqualTo(Integer.valueOf(recommed));
        }
        return blogMapper.selectByExample(example);
    }

    @Override
    public List<Blog> search(String query) {
        BlogExample example = new BlogExample();
        example.or().andTitleLike("%"+query+"%");
        example.or().andDescriptionLike("%"+query+"%");
        return blogMapper.selectByExample(example);
    }

    @Override
    public Map<String, List<Blog>> getArchiveBlog() {
        List<String> years = blogMapper.getYear();
        Map<String,List<Blog>> map = new LinkedHashMap<>();
        for (String year:years){
            map.put(year,blogMapper.getBlogByYear(year));
        }
        return map;
    }

    @Override
    public Integer getCountBlogs() {
        return blogMapper.getCountBlogs();
    }

    @Override
    public List<Blog> getByTypeId(Long id) {
        BlogExample example = new BlogExample();
        example.createCriteria().andType_idEqualTo(id);
        return blogMapper.selectByExample(example);
    }

    @Override
    public List<Blog> getFiveBlog() {
        return blogMapper.getFiveBlog();
    }
}
