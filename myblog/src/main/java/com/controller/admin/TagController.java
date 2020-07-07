package com.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Tag;
import com.service.ITagService;
import com.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private ITagService tagService;

    @GetMapping("/tags")
    public String tags(Page page, Model model){;
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Tag> allTags = tagService.getAllTags();
        PageInfo<Tag> PageInfo = new PageInfo<>(allTags);
        int total = (int) PageInfo.getTotal();
        page.setTotal(total);

        model.addAttribute("page",page);
        model.addAttribute("tags",allTags);
        return "admin/tags";
    }

    @GetMapping("/tag/input")
    public String tagInputPage(Model model){
        model.addAttribute("tag",new Tag());
        return "admin/tags-input";
    }

    @PostMapping("/tag/addTag")
    public String addTag(Tag tag, RedirectAttributes attributes){
        Tag tag1 = tagService.getTagByName(tag.getName());
        if (tag1 != null){
            attributes.addFlashAttribute("message","不能添加重复的分类");
            return "redirect:/admin/tag/input";
        }
        tagService.saveTag(tag);
        return "redirect:/admin/tags";
    }

    @GetMapping("/tag/toEditPage/{id}")
    public String toEditPage(@PathVariable("id") Long id, Model model){
        Tag tag = tagService.getTagById(id);
        model.addAttribute("tag",tag);
        return "admin/tags-input";
    }

    @PostMapping("/tag/editTag/{id}")
    public String editTag(@PathVariable Long id,Tag tag, RedirectAttributes attributes){
        Tag tag1 = tagService.getTagByName(tag.getName());
        if (tag1 != null){
            attributes.addFlashAttribute("message","不能修改为重复的分类");
            return "redirect:/admin/tag/toEditPage/"+id;
        }
        tagService.updateTag(tag);
        return "redirect:/admin/tags";
    }

    @GetMapping("tag/delete/{id}")
    public String delTag(@PathVariable("id") Long id){
        tagService.deleteTag(id);
        return "redirect:/admin/tags";
    }
}
