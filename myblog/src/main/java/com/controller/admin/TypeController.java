package com.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Type;
import com.service.ITypeService;
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
public class TypeController {

    @Autowired
    private ITypeService typeService;

    @GetMapping("/types")
    public String types(Page page, Model model){;
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Type> allTypes = typeService.getAllTypes();
        PageInfo<Type> PageInfo = new PageInfo<>(allTypes);
        int total = (int) PageInfo.getTotal();
        page.setTotal(total);

        model.addAttribute("page",page);
        model.addAttribute("types",allTypes);
        return "admin/types";
    }

    @GetMapping("/type/input")
    public String typeInputPage(Model model){
        model.addAttribute("type",new Type());
        return "admin/types-input";
    }

    @PostMapping("/type/addType")
    public String addType(Type type, RedirectAttributes attributes){
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null){
            attributes.addFlashAttribute("message","不能添加重复的分类");
            return "redirect:/admin/type/input";
        }
        typeService.saveType(type);
        return "redirect:/admin/types";
    }

    @GetMapping("/type/toEditPage/{id}")
    public String toEditPage(@PathVariable("id") Long id,Model model){
        Type type = typeService.getTypeById(id);
        model.addAttribute("type",type);
        return "admin/types-input";
    }

    @PostMapping("/type/editType/{id}")
    public String editType(@PathVariable Long id,Type type, RedirectAttributes attributes){
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null){
            attributes.addFlashAttribute("message","不能修改为重复的分类");
            return "redirect:/admin/type/toEditPage/"+id;
    }
        typeService.updateType(type);
        return "redirect:/admin/types";
    }

    @GetMapping("type/delete/{id}")
    public String delType(@PathVariable("id") Long id){
        typeService.deleteType(id);
        return "redirect:/admin/types";
    }
}
