package com.service;

import com.pojo.Route;

import java.util.List;

public interface IRouteService {

    public List<Route> findAllRoutes();

    public List<Route> randFive();

    public Route findRouteByRid(int rid);

    public List<Route> findRouteByCid(int cid);

    public List<Route> searchRoute(String rname);

    public boolean findByRidAndUid(int rid,int uid);
    //根据rid和uid保存favourite信息
    public void save(int rid,int uid);

    public Route findByRid(int rid);

    public void updateRoute(Route route);

    //查询6条路线显示在首页
    public List<Route> findSix(int cid);

}
