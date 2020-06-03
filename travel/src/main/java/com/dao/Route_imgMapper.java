package com.dao;

import com.pojo.Route_img;
import com.pojo.Route_imgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Route_imgMapper {
    int countByExample(Route_imgExample example);

    int deleteByExample(Route_imgExample example);

    int deleteByPrimaryKey(Integer rgid);

    int insert(Route_img record);

    int insertSelective(Route_img record);

    List<Route_img> selectByExample(Route_imgExample example);

    Route_img selectByPrimaryKey(Integer rgid);

    int updateByExampleSelective(@Param("record") Route_img record, @Param("example") Route_imgExample example);

    int updateByExample(@Param("record") Route_img record, @Param("example") Route_imgExample example);

    int updateByPrimaryKeySelective(Route_img record);

    int updateByPrimaryKey(Route_img record);
}