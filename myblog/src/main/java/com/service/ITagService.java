package com.service;

import com.pojo.Tag;
import com.pojo.Type;

import java.util.List;

public interface ITagService {

    //查询所有type
    List<Tag> getAllTags();

    //根据id查询
    Tag getTagById(Long id);

    //根据name查询
    Tag getTagByName(String name);

    //新增
    void saveTag(Tag tag);

    //修改
    void  updateTag(Tag tag);

    //删除
    void  deleteTag(Long id);
}
