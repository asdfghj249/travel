package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Favorite;
import com.pojo.Route;
import com.pojo.User;
import com.service.IFavouriteService;
import com.service.IRouteService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/fav")
public class FavouriteController {

    @Autowired
    IFavouriteService favouriteService;
    @Autowired
    IRouteService routeService;



    @RequestMapping("/myfavourite")
    public String myfavourite(HttpSession session, Model model,Page page){
        page.setCount(12);
        PageHelper.offsetPage(page.getStart(),page.getCount());

        User user = (User) session.getAttribute("user");
        int uid = user.getUid();
        //分页只能进行一次查询
       // List<Route> favRoutes = favouriteService.findFavRoute(uid); 错误（查询2次）
        List<Favorite> favRoutes1 = favouriteService.findfav(uid);
        int total = (int) new PageInfo<>(favRoutes1).getTotal();
        page.setTotal(total);

        List<Route> favRoutes = new ArrayList<>();
        for(Favorite f:favRoutes1){
            int rid = f.getRid();
            Route routeByRid = routeService.findByRid(rid);
            favRoutes.add(routeByRid);
        }


        int begin,end;

        if(page.getTotalPage()<10){
            begin = 1;
            end = page.getTotalPage();
        }else {
            begin = page.getCurrentPage() - 5;
            end = page.getCurrentPage() + 4;

            if (begin<1){
                begin = 1;
                end = begin + 9;
            }
            if(end > page.getTotalPage()){
                end = page.getTotalPage();
                begin = end - 9;
            }
        }



        model.addAttribute("end",end);
        model.addAttribute("begin",begin);
        model.addAttribute("page",page);
        model.addAttribute("total",total);
        model.addAttribute("myfavRoutes",favRoutes);
        return "myfavourite";
    }

    @RequestMapping("/favouriteRank")
    public String favouriteRank(Model model,Page page){
        //测试合并分支222
        page.setCount(6);
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Route> routes = favouriteService.FavRank();
        int total = (int) new PageInfo<>(routes).getTotal();
        page.setTotal(total);

        int begin,end;
        if (page.getTotalPage()<10){
            begin = 1;
            end = page.getTotalPage();
        }else {
            begin = page.getCurrentPage() - 5;
            end = page.getCurrentPage() + 4;
            if (begin<1){
                begin = 1;
                end = begin + 9;
            }
            if (end > page.getTotalPage()){
                end = page.getTotalPage();
                begin = end - 9;
            }
        }

        model.addAttribute("routes",routes);
        model.addAttribute("page",page);
        model.addAttribute("begin",begin);
        model.addAttribute("end",end);
        model.addAttribute("total",total);
        return "favouriterank";
    }

}
