package com.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.*;
import com.service.IBlogService;
import com.service.IBlogTagService;
import com.service.ITagService;
import com.service.ITypeService;
import com.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private IBlogService blogService;
    @Autowired
    private ITagService tagService;
    @Autowired
    private ITypeService typeService;
    @Autowired
    private IBlogTagService blogTagService;

    private String BTitle=null;
    private String BType_id=null;
    private String BRecommed=null;

    @GetMapping("/blogs")
    public String blogs(Page page, Model model) {
        //获得blog并分页
        page.setCount(3);
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Blog> blogs = blogService.getAllBlogs();
        int total = (int) new PageInfo<>(blogs).getTotal();
        page.setTotal(total);
        //查询所有标签
        List<Tag> tags = tagService.getAllTags();
        //查询所有分类
        List<Type> types = typeService.getAllTypes();
        //给博客绑定标签属性
       /* for (Blog blog:blogs){
            List<Tag> list = new ArrayList<>();
            String tag_ids = blog.getTag_ids();
            String[] t_id = tag_ids.split(",");
            for (String tid:t_id){
                Tag tag = tagService.getTagById((long) Integer.parseInt(tid));
                list.add(tag);
            }
            blog.setTags(list);
        }*/

        //给博客绑定类型属性
        for (Blog blog : blogs) {
            Type type = typeService.getTypeById(blog.getType_id());
            blog.setType(type);
        }

        model.addAttribute("blogs", blogs);
        model.addAttribute("tags", tags);
        model.addAttribute("types", types);
        model.addAttribute("page", page);
        return "/admin/blogs";
    }


    @RequestMapping("/blogs/search")
    public String search(HttpServletRequest request, Model model, Page page) {
        String title = request.getParameter("title");
        String type_id = request.getParameter("type");
        String recommed = request.getParameter("recommed");

        //System.out.println(title+":"+type_id+":"+recommed);
        page.setCount(2);
        PageHelper.offsetPage(page.getStart(), page.getCount());
        if(title!=null) BTitle = title;
        if(type_id!=null) BType_id = type_id;
        if(recommed!=null) BRecommed = recommed;
        List<Blog> blogs = blogService.searchBlogs(BTitle, BType_id, BRecommed);
        int total = (int) new PageInfo<>(blogs).getTotal();
        page.setTotal(total);

        //查询所有分类
        List<Type> types = typeService.getAllTypes();
        //给博客绑定类型属性
        for (Blog blog : blogs) {
            Type type = typeService.getTypeById(blog.getType_id());
            blog.setType(type);
        }

        model.addAttribute("blogs", blogs);
        model.addAttribute("types", types);
        model.addAttribute("page", page);
        return "/admin/blogs";
    }

    @GetMapping("/blogs/toAddBlog")
    public String toAddBlogPage(Model model){
        model.addAttribute("blog" ,new Blog());
        model.addAttribute("tags" ,tagService.getAllTags());
        model.addAttribute("types" ,typeService.getAllTypes());
        return "admin/blogs-input";
    }

    @PostMapping("/blogs/addBlog")
    public String addBlog(Blog blog, HttpSession session){
        User user = (User) session.getAttribute("user");
        blog.setUser_id(user.getId());
        blogService.saveBlog(blog);

        setBlogAndTag(blog);

        return "redirect:/admin/blogs";
    }

    private static List<Long> toLongList(String tag_ids){
        String[] tid = tag_ids.split(",");
        List<Long> list = new ArrayList<>();
        for (String s:tid){
            list.add(Long.valueOf(s));
        }
        return list;
    }

    private void setBlogAndTag(Blog blog){
        String tag_ids = blog.getTag_ids();
        List<Long> tid = toLongList(tag_ids);
        for (Long id:tid){
            BlogTags blogTags = new BlogTags();
            blogTags.setBlog_id(blog.getId().toString());
            blogTags.setTag_id(id);
            blogTagService.save(blogTags);
        }
    }

    @GetMapping("/blogs/toEditBlog/{id}")
    public String toEditBlogPage(Model model,@PathVariable("id") Long id){
        model.addAttribute("blog" ,blogService.getBlogById(id));
        model.addAttribute("tags" ,tagService.getAllTags());
        model.addAttribute("types" ,typeService.getAllTypes());
        return "admin/blogs-input";
    }

    @PostMapping("/blogs/editBlog/{id}")
    public String editBlog(Blog blog, HttpSession session,@PathVariable("id") Long id){
        User user = (User) session.getAttribute("user");
        blog.setUser_id(user.getId());
        blogService.updateBlog(blog);

        blogTagService.deleteByBlogId(id);
        setBlogAndTag(blog);

        return "redirect:/admin/blogs";
    }


    @GetMapping("/blogs/deleteBlog/{id}")
    public String delBlog(@PathVariable("id") Long id){
        blogService.deleteBlog(id);
        blogTagService.deleteByBlogId(id);
        return "redirect:/admin/blogs";
    }



}
