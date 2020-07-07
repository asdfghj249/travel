package com.service.impl;

import com.dao.CommentMapper;
import com.pojo.Comment;
import com.pojo.CommentExample;
import com.service.ICommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class CommentServiceImpl implements ICommentService {

    @Resource
    private CommentMapper commentMapper;
    @Override
    public List<Comment> getAllComments(Long id) {
        CommentExample example = new CommentExample();
        example.createCriteria().andBlog_idEqualTo(id).andParent_comment_idEqualTo(Long.valueOf("-1"));

        //查出所有顶级评论
        List<Comment> comments = commentMapper.selectByExample(example);
        //设置顶级评论的子评论
        repeat(comments);
        return  eachComment(comments);
    }

    @Override
    public void saveComment(Comment comment) {
        comment.setCreate_time(new Date());
        commentMapper.insert(comment);
    }



    //获取父评论下的所有子评论
    private List<Comment> getReplyComments(Long id){
       CommentExample example = new CommentExample();
       example.createCriteria().andParent_comment_idEqualTo(id);
       return commentMapper.selectByExample(example);
    }
    //给每个评论设置子评论
    private void repeat(List<Comment> comments){
        for (Comment comment:comments){
            List<Comment> replyComments = getReplyComments(comment.getId());
            comment.setReplyComments(replyComments);
            repeat(replyComments);
        }
    }

    //设置所有评论的父评论
    private void setFComments(List<Comment> comments) {
        for (Comment c : comments) {
            if (c.getParent_comment_id() != -1) {
                c.setParentComment(commentMapper.selectByPrimaryKey(c.getParent_comment_id()));
            }
        }
    }



    /**
     * 循环每个顶级的评论节点
     * @param comments
     * @return
     */
    private List<Comment> eachComment(List<Comment> comments) {
        List<Comment> commentsView = new ArrayList<>();
        for (Comment comment : comments) {
            Comment c = new Comment();
            BeanUtils.copyProperties(comment,c);
            commentsView.add(c);
        }
        //合并评论的各层子代到第一级子代集合中
        combineChildren(commentsView);
        return commentsView;
    }

    /**
     * @param comments root根节点，blog不为空的对象集合
     * @return
     */
    private void combineChildren(List<Comment> comments) {

        for (Comment comment : comments) {
            List<Comment> replys1 = comment.getReplyComments();
            for(Comment reply1 : replys1) {
                //循环迭代，找出子代，存放在tempReplys中
                recursively(reply1);
            }
            //给所有子代集合设置父评论
            setFComments(tempReplys);
            //修改顶级节点的reply集合为迭代处理后的集合
            comment.setReplyComments(tempReplys);
            //清除临时存放区
            tempReplys = new ArrayList<>();
        }
    }

    //存放迭代找出的所有子代的集合
    private List<Comment> tempReplys = new ArrayList<>();
    /**
     * 递归迭代，剥洋葱
     * @param comment 被迭代的对象
     * @return
     */
    private void recursively(Comment comment) {
        tempReplys.add(comment);//顶节点添加到临时存放集合
        if (comment.getReplyComments().size()>0) {
            List<Comment> replys = comment.getReplyComments();
            for (Comment reply : replys) {
                tempReplys.add(reply);
                if (reply.getReplyComments().size()>0) {
                    recursively(reply);
                }
            }
        }
    }
}
