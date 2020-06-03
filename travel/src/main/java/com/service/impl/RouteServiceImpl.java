package com.service.impl;

import com.dao.FavoriteMapper;
import com.dao.RouteMapper;
import com.dao.SellerMapper;
import com.pojo.*;
import com.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class RouteServiceImpl implements IRouteService {

    @Autowired
    RouteMapper routeMapper;
    @Autowired
    SellerMapper sellerMapper;
    @Autowired
    FavoriteMapper favoriteMapper;

    @Override
    public List<Route> findAllRoutes() {
        return routeMapper.selectByExample(null);
    }

    @Override
    public List<Route> randFive() {
        List<Route> routes = routeMapper.randFive();
        return routes;
    }

    //查询路线并给路线设置商家属性
    @Override
    public Route findRouteByRid(int rid) {
        Route route = routeMapper.selectByPrimaryKey(rid);
        int sid = route.getSid();
        Seller seller = sellerMapper.selectByPrimaryKey(sid);
        route.setSeller(seller);
        return route;
    }

    @Override
    public List<Route> findRouteByCid(int cid) {
        RouteExample example = new RouteExample();
        example.createCriteria().andCidEqualTo(cid);
        List<Route> routes = routeMapper.selectByExample(example);
        return routes;
    }

    @Override
    public List<Route> searchRoute(String rname) {
        RouteExample example = new RouteExample();
        example.createCriteria().andRnameLike("%"+rname+"%");
        List<Route> routes = routeMapper.selectByExample(example);
        return routes;
    }

    @Override
    public boolean findByRidAndUid(int rid,int uid) {
        FavoriteExample example = new FavoriteExample();
        example.createCriteria().andRidEqualTo(rid).andUidEqualTo(uid);
        List<Favorite> favorites = favoriteMapper.selectByExample(example);

        if (favorites.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void save(int rid, int uid) {
        Favorite favorite = new Favorite();
        Date date = new Date();
        favorite.setRid(rid);
        favorite.setUid(uid);
        favorite.setDate(date);
        favoriteMapper.insert(favorite);
    }

    @Override
    public Route findByRid(int rid) {
        return routeMapper.selectByPrimaryKey(rid);
    }

    @Override
    public void updateRoute(Route route) {
        routeMapper.updateByPrimaryKeySelective(route);
    }

    @Override
    public List<Route> findSix(int cid) {
        List<Route> sixRoutes = routeMapper.findSix(cid);
        return sixRoutes;
    }


}
