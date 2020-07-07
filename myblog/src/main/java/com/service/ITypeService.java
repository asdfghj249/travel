package com.service;

import com.pojo.Type;

import java.util.List;

public interface ITypeService {

    //查询所有type
    List<Type> getAllTypes();

    //根据id查询
    Type getTypeById(Long id);

    //根据name查询
    Type getTypeByName(String name);

    //新增
    void saveType(Type type);

    //修改
    void  updateType(Type type);

    //删除
    void  deleteType(Long id);

    //查询五条记录，用于首页
    List<Type> getFiveType();
}
