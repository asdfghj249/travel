package com.pojo;

import lombok.ToString;

import java.util.Date;
import java.util.List;

public class Comment {
    private Long id;

    private String nickname;

    private String email;

    private String content;

    private String avatar;

    private Date create_time;

    private Long blog_id;

    private Long parent_comment_id;

    private Integer admincomment;

    private Blog blog;

    private Comment parentComment;

    private List<Comment> replyComments;

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public List<Comment> getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(List<Comment> replyComments) {
        this.replyComments = replyComments;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Long getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(Long blog_id) {
        this.blog_id = blog_id;
    }

    public Long getParent_comment_id() {
        return parent_comment_id;
    }

    public void setParent_comment_id(Long parent_comment_id) {
        this.parent_comment_id = parent_comment_id;
    }

    public Integer getAdmincomment() {
        return admincomment;
    }

    public void setAdmincomment(Integer admincomment) {
        this.admincomment = admincomment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", avatar='" + avatar + '\'' +
                ", create_time=" + create_time +
                ", blog_id=" + blog_id +
                ", parent_comment_id=" + parent_comment_id +
                ", admincomment=" + admincomment +
                ", parentComment=" + parentComment +
                ", replyComments=" + replyComments +
                '}';
    }
}