package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Blog;
import com.pojo.BlogTags;
import com.pojo.Tag;
import com.service.*;
import com.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Comparator;
import java.util.List;

@Controller
public class ForeTagController {

    @Autowired
    private ITagService tagService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IBlogTagService blogTagService;
    @Autowired
    private ITypeService typeService;
    @Autowired
    private IBlogService blogService;

    @GetMapping("/tag/{id}")
    public String toTagPage(Model model, Page page, @PathVariable("id") Long id){
        List<Tag> tags = tagService.getAllTags();
        if (id == -1){
            id = tags.get(0).getId() ;
        }

        page.setCount(2);
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Blog> blogs = blogTagService.getBlogByTid(id);

        //blog绑定type属性
        for (Blog blog:blogs){
            blog.setType(typeService.getTypeById(blog.getType_id()));
            blog.setUser(userService.getById(blog.getUser_id()));
            blog.setTags(blogTagService.getByBId(blog.getId()));
        }
        int total = (int) new PageInfo<>(blogs).getTotal();
        page.setTotal(total);


        for (Tag tag:tags){
            tag.setBlogs(blogTagService.getByTagId(tag.getId()));
        }
        //按照tag下的blog数量进行排序
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

        model.addAttribute("tags",tags);
        model.addAttribute("blogs",blogs);
        model.addAttribute("activeId",id);
        return "tags";
    }
}
