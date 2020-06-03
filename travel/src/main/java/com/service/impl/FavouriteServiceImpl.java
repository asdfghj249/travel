package com.service.impl;

import com.dao.FavoriteMapper;
import com.dao.RouteMapper;
import com.dao.UserMapper;
import com.pojo.*;
import com.service.IFavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavouriteServiceImpl implements IFavouriteService {

    @Autowired
    FavoriteMapper favoriteMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RouteMapper routeMapper;

    @Override
    public int countRid(int rid) {
        FavoriteExample example = new FavoriteExample();
        example.createCriteria().andRidEqualTo(rid);
        int count = favoriteMapper.countByExample(example);
        return count;
    }

    //根据uid查询用户收藏的路线
    //并给用户设置favorite属性
    @Override
    public User findByUid(int uid) {
        FavoriteExample example = new FavoriteExample();
        example.createCriteria().andUidEqualTo(uid);
        List<Favorite> favorites = favoriteMapper.selectByExample(example);

        User user = userMapper.selectByPrimaryKey(uid);
        user.setFavorites(favorites);
        return user;
    }

    public List<Favorite> findfav(int uid){
        FavoriteExample example = new FavoriteExample();
        example.createCriteria().andUidEqualTo(uid);
        List<Favorite> favorites = favoriteMapper.selectByExample(example);
        return favorites;

    }


    public List<Route> findFavRoute(int uid){
        List<Route> routes = new ArrayList<Route>();
        FavoriteExample example = new FavoriteExample();
        example.createCriteria().andUidEqualTo(uid);
        List<Favorite> favorites = favoriteMapper.selectByExample(example);

        for(Favorite f:favorites){
            int rid = f.getRid();
            Route route = routeMapper.selectByPrimaryKey(rid);
            routes.add(route);
        }

        return routes;
    }



    @Override
    public List<Route> FavRank() {
        RouteExample example = new RouteExample();
        example.setOrderByClause("count desc");
        example.createCriteria().andCountGreaterThan(0);
        List<Route> routes = routeMapper.selectByExample(example);

        return routes;
    }


}
