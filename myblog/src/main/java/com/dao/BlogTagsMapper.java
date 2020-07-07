package com.dao;

import com.pojo.Blog;
import com.pojo.BlogTags;
import com.pojo.BlogTagsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogTagsMapper {
    int countByExample(BlogTagsExample example);

    int deleteByExample(BlogTagsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlogTags record);

    int insertSelective(BlogTags record);

    List<BlogTags> selectByExample(BlogTagsExample example);

    BlogTags selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlogTags record, @Param("example") BlogTagsExample example);

    int updateByExample(@Param("record") BlogTags record, @Param("example") BlogTagsExample example);

    int updateByPrimaryKeySelective(BlogTags record);

    int updateByPrimaryKey(BlogTags record);

    List<Blog> getBlogsByTid(Long id);
}