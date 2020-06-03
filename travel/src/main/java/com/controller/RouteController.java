package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Category;
import com.pojo.Route;
import com.pojo.User;
import com.service.ICategoryService;
import com.service.IFavouriteService;
import com.service.IRouteService;
import com.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/route")
public class RouteController {

    @Autowired
    IRouteService routeService;
    @Autowired
    IFavouriteService favouriteService;
    @Autowired
    ICategoryService categoryService;

    @RequestMapping("/findRoutes")
    public String findAllRoutes(Page page, Model model,@RequestParam("cid") int cid){
        PageHelper.offsetPage(page.getStart(),page.getCount());
        //List<Route> allRoutes = routeService.findAllRoutes();
        List<Route> allRoutes = routeService.findRouteByCid(cid);
        int total = (int) new PageInfo<>(allRoutes).getTotal();
        page.setTotal(total);


        //随机五条路线
        List<Route> routes = routeService.randFive();

            /*1.2 展示分页页码

                1.一共展示10个页码，能够达到前5后4的效果
                2.如果前边不够5个，后边补齐10个
                3.如果后边不足4个，前边补齐10个*/


        // 定义开始位置begin,结束位置 end
        int begin; // 开始位置
        int end ; //  结束位置


        //1.要显示10个页码
        if(page.getTotalPage() < 10){
            //总页码不够10页

            begin = 1;
            end = page.getTotalPage();
        }else{
            //总页码超过10页

            begin = page.getCurrentPage() - 5 ;
            end = page.getCurrentPage() + 4 ;

            //2.如果前边不够5个，后边补齐10个
            if(begin < 1){
                begin = 1;
                end = begin + 9;
            }

            //3.如果后边不足4个，前边补齐10个
            if(end > page.getTotalPage()){
                end = page.getTotalPage();
                begin = end - 9 ;
            }
        }

        model.addAttribute("routes",routes);
        model.addAttribute("begin",begin);
        model.addAttribute("end",end);
        model.addAttribute("total",total);
        model.addAttribute("page",page);
        model.addAttribute("allRoutes",allRoutes);
        model.addAttribute("cid",cid);
        return "route_list";
    }

    @RequestMapping("/routeDetail")
    public String routeDetail(Model model, @RequestParam("rid") int rid, HttpSession session){
        User user = (User) session.getAttribute("user");
        boolean flag=true;
        if(user!=null){
           int uid = user.getUid();

            //判断是否收藏
            flag = routeService.findByRidAndUid(rid, uid);

            Route routeByid = routeService.findByRid(rid);
            int count = favouriteService.countRid(rid);
            routeByid.setCount(count);
            routeService.updateRoute(routeByid);


            //查询路线
            Route route = routeService.findRouteByRid(rid);

            int cid = route.getCid();
            Category category = categoryService.findOne(cid);

            model.addAttribute("category",category);
            model.addAttribute("count",count);
            model.addAttribute("flag",flag);
            model.addAttribute("route",route);
        }else {

            Route route = routeService.findRouteByRid(rid);
            int cid = route.getCid();
            Category category = categoryService.findOne(cid);

            model.addAttribute("category",category);
            model.addAttribute("flag",flag);
            model.addAttribute("route",route);
        }


        return "route_detail";
    }


    @RequestMapping("/addToFavourite")
    @ResponseBody
    public String addToFavourite(HttpSession session,int rid,int uid){
        User user = (User) session.getAttribute("user");
        if (user == null){
            return "false";
        }

        routeService.save(rid,uid);

        return "success";
    }

    @RequestMapping("/isLogin")
    @ResponseBody
    public String isLogin(HttpSession session){
        User user = (User) session.getAttribute("user");
        return  user==null ? "false":"true";
    }

}
