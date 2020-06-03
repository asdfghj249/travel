package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Category;
import com.pojo.Route;
import com.pojo.User;
import com.service.ICategoryService;
import com.service.IRouteService;
import com.service.IUserService;
import com.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/fore")
public class ForeController {

    @Autowired
    private IUserService userService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IRouteService routeService;

    public String Rname=null;

    @RequestMapping("/forIndex")
    public String foreIndex(HttpSession session,Model model){
        List<Category> categories = categoryService.findAll();

        List<Route> GuoNei = routeService.findSix(5);

        List<Route> JinWai = routeService.findSix(4);

        List<Route> allRoutes = routeService.findAllRoutes();


        model.addAttribute("allroutes",allRoutes);
        model.addAttribute("Guonei",GuoNei);
        model.addAttribute("Jinwai",JinWai);
        session.setAttribute("categories",categories);
        return "index2";
    }

    @RequestMapping("/registerUI")
    public String registerUI(){
        return "register";
    }

    @RequestMapping("/register")
    public String register( User user){
        userService.save(user);
        return "register_success";
    }

    @RequestMapping("/loginUI")
    public String loginUI(){
        return "login";
    }



    @RequestMapping("/login")
    public String login(User user, HttpSession session, Model model){
        User loginUser = userService.login(user);

        if(loginUser != null){
            session.setAttribute("user",loginUser);
            return "redirect:forIndex";
        }else {
            model.addAttribute("error","用户名或密码错误");
            return "login";
        }

    }

    @RequestMapping("/logout")
    public String logOut(HttpSession session){
        session.setAttribute("user",null);
        return "redirect:loginUI";
    }

    @RequestMapping("/searchRoute")
    public String searchRoute(Model model, Page page, String rname){

        PageHelper.offsetPage(page.getStart(),page.getCount());
        if (rname !=null) Rname = rname;
        List<Route> routes = routeService.searchRoute(Rname);
        int total = (int) new PageInfo<>(routes).getTotal();
        page.setTotal(total);


        List<Route> routes1 = routeService.randFive();

        int begin,end;

        if(page.getTotalPage()<10){
            begin = 1;
            end = page.getTotalPage();
        }else {
            begin = page.getCurrentPage() - 5;
            end = page.getCurrentPage() + 4;

            if(begin<1){
                begin = 1;
                end = begin + 9;
            }
            if(end>page.getTotalPage()){
                end = page.getTotalPage();
                begin = end - 9;
            }
        }

        model.addAttribute("routes",routes);
        model.addAttribute("page",page);
        model.addAttribute("total",total);
        model.addAttribute("routes1",routes1);
        model.addAttribute("begin",begin);
        model.addAttribute("end",end);
        return "search_routes";
    }



}
