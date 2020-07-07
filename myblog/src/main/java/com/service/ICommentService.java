package com.service;

import com.pojo.Comment;

import java.util.List;

public interface ICommentService {

    //查找所有评论按照时间降序
    List<Comment> getAllComments(Long id);

    //保存
    void saveComment(Comment comment);
}
