package com.controller;

import com.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForeArchivesController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("/archives")
    public String toArchivesPage(Model model){
        model.addAttribute("archives",blogService.getArchiveBlog());
        model.addAttribute("count",blogService.getCountBlogs());
        return "archives";
    }
}
