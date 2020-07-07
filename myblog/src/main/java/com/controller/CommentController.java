package com.controller;

import com.pojo.Comment;
import com.pojo.User;
import com.service.IBlogService;
import com.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private ICommentService commentService;
    @Autowired
    private IBlogService blogService;

    @Value("${comment.avatar}")
    private String avatar;

    @GetMapping("/comments/{blogId}")
    public String toCommentList(Model model, @PathVariable("blogId") Long id) {
        model.addAttribute("comments", commentService.getAllComments(id));
        return "blog :: commentList";
    }

    @PostMapping("/comments")
    public String subComment(Comment comment, HttpSession session){
        Long blogId = comment.getBlog_id();

        User user = (User) session.getAttribute("user");
        if (user != null) {
            comment.setAvatar(user.getAvatar());
            comment.setAdmincomment(1);
        } else {
            comment.setAvatar(avatar);
            comment.setAdmincomment(0);
        }
        commentService.saveComment(comment);

        return "redirect:/comments/"+ blogId;
    }
}
