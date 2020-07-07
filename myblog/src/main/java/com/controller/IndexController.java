package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import com.pojo.Blog;
import com.pojo.BlogTags;
import com.pojo.Tag;
import com.pojo.Type;
import com.service.*;
import com.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private IBlogService blogService;
    @Autowired
    private ITypeService typeService;
    @Autowired
    private ITagService tagService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IBlogTagService blogTagService;

    private String Query = null;

    @GetMapping("/")
    public String toIndex(Model model, Page page){
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Blog> blogs = blogService.getAllBlogs1();
        int total = (int) new PageInfo<>(blogs).getTotal();
        page.setTotal(total);
        //blog绑定type属性
        for (Blog blog:blogs){
            blog.setType(typeService.getTypeById(blog.getType_id()));
            blog.setUser(userService.getById(blog.getUser_id()));
            blog.setTags(blogTagService.getByBId(blog.getId()));
        }

        List<Type> types = typeService.getFiveType();
        for (Type type:types){
            type.setBlogs(blogService.getByTypeId(type.getId()));
        }
        //按照type下的blog数量进行排序
        Collections.sort(types, new Comparator<Type>() {
            @Override
            public int compare(Type type1, Type type2) {
                if (type1.getBlogs().size()>type2.getBlogs().size()){
                    return -1;
                }else if (type1.getBlogs().size()==type2.getBlogs().size()){
                    return 0;
                }
                return 1;
            }
        });

        List<Tag> tags = tagService.getAllTags();
        for (Tag tag:tags){
            tag.setBlogs(blogTagService.getByTagId(tag.getId()));
        }

        tags.sort(new Comparator<Tag>() {
            @Override
            public int compare(Tag tag1, Tag tag2) {
                if (tag1.getBlogs().size() > tag2.getBlogs().size()) {
                    return -1;
                } else if (tag1.getBlogs().size() == tag2.getBlogs().size()) {
                    return 0;
                }
                return 1;
            }
        });


        List<Blog> fiveBlogs = blogService.getFiveBlog();

        model.addAttribute("blogs",blogs);
        model.addAttribute("fiveBlogs",fiveBlogs);
        model.addAttribute("types",types);
        model.addAttribute("tags",tags);
        model.addAttribute("page",page);
        return "index";
    }

    @RequestMapping("/search")
    public String search(Page page, Model model, @RequestParam(value = "query",required = false) String query){
        PageHelper.offsetPage(page.getStart(),page.getCount());
        if (query != null) Query = query;
        List<Blog> blogs = blogService.search(Query);
        int total = (int) new PageInfo<>(blogs).getTotal();
        page.setTotal(total);
        //blog绑定type属性
        for (Blog blog:blogs){
            blog.setType(typeService.getTypeById(blog.getType_id()));
            blog.setUser(userService.getById(blog.getUser_id()));
        }

        model.addAttribute("blogs",blogs);
        model.addAttribute("page",page);
        model.addAttribute("query",query);
        return "search";
    }


    @GetMapping("/blog/{id}")
    public String toBlogPage(@PathVariable("id") Long id,Model model){
        Blog blog = blogService.getAndConvert(id);

        blog.setType(typeService.getTypeById(blog.getType_id()));
        blog.setUser(userService.getById(blog.getUser_id()));
        blog.setTags(blogTagService.getByBId(id));

        model.addAttribute("blog",blog);
        return "blog";
    }

    @GetMapping("/footer/newBlog")
    public String newBlog(Model model){
        List<Blog> allBlogs = blogService.getAllBlogs();
        List<Blog> newblogs = new ArrayList<>();
        for(int i = 0;i<3;i++){
            newblogs.add(allBlogs.get(i));
        }
        model.addAttribute("newblogs",newblogs);
        return "public :: newblogList";
    }

}
