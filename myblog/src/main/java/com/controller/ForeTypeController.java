package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Blog;
import com.pojo.Type;
import com.service.IBlogService;
import com.service.IBlogTagService;
import com.service.ITypeService;
import com.service.IUserService;
import com.util.Page;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class ForeTypeController {

    @Autowired
    private ITypeService typeService;
    @Autowired
    private IBlogService blogService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IBlogTagService blogTagService;

    @GetMapping("/type/{id}")
    public String type(Model model, Page page, @PathVariable("id") Long id){
        //所有type
        List<Type> types = typeService.getAllTypes();
        if (id == -1){
            id = types.get(0).getId();
        }
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Blog> blogs = blogService.getByTypeId(id);
        //blog绑定type属性
        for (Blog blog:blogs){
            blog.setType(typeService.getTypeById(blog.getType_id()));
            blog.setUser(userService.getById(blog.getUser_id()));
            blog.setTags(blogTagService.getByBId(blog.getId()));
        }
        int total = (int) new PageInfo<>(blogs).getTotal();
        page.setTotal(total);

        for (Type type:types){
            type.setBlogs(blogService.getByTypeId(type.getId()));
        }

        //按照type下的blog数量进行排序
        types.sort(new Comparator<Type>() {
            @Override
            public int compare(Type type1, Type type2) {
                if (type1.getBlogs().size() > type2.getBlogs().size()) {
                    return -1;
                } else if (type1.getBlogs().size() == type2.getBlogs().size()) {
                    return 0;
                }
                return 1;
            }
        });

        model.addAttribute("types",types);
        model.addAttribute("blogs",blogs);
        model.addAttribute("activeId",id);
        return "types";
    }
}
