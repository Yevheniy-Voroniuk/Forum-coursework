package com.example.Forum.controllers;

import com.example.Forum.models.Comment;
import com.example.Forum.models.Post;
import com.example.Forum.services.CommentService;
import com.example.Forum.services.PostService;
import com.example.Forum.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class CommentController {

    private final CommentService commentService;
    private final PostService postService;
    private final UserService userService;

    @Autowired
    public CommentController(CommentService commentService, PostService postService, UserService userService) {
        this.commentService = commentService;
        this.postService = postService;
        this.userService = userService;
    }

    @PostMapping("/topic/{topicId}/{postId}/add-comment")
    public String addComment(@PathVariable("topicId") Long topicId, @PathVariable("postId") Long postId,
                             @ModelAttribute Comment comment, Principal principal) {
        Post post = postService.getPostById(postId);
        comment.setPost(post);
        comment.setAuthor(userService.findByUsername(principal.getName()));
        commentService.createComment(comment);
        return "redirect:/topic/{topicId}/{postId}";
    }
}