package com.service;

import com.pojo.Favorite;
import com.pojo.Route;
import com.pojo.User;

import java.util.List;

public interface IFavouriteService {

    public int countRid(int rid);

    public User findByUid(int uid);

    public List<Route> findFavRoute(int uid);

    public List<Route> FavRank();

    public List<Favorite> findfav(int uid);

}
