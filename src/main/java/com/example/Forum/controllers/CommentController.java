package com.example.Forum.controllers;

import com.example.Forum.models.Comment;
import com.example.Forum.models.Post;
import com.example.Forum.services.CommentService;
import com.example.Forum.services.PostService;
import com.example.Forum.services.TopicService;
import com.example.Forum.services.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class CommentController {

    private final CommentService commentService;
    private final PostService postService;
    private final UserService userService;
    private final TopicService topicService;

    @Autowired
    public CommentController(CommentService commentService, PostService postService, UserService userService, TopicService topicService) {
        this.commentService = commentService;
        this.postService = postService;
        this.userService = userService;
        this.topicService = topicService;
    }

    @PostMapping("/topic/{topicId}/{postId}/add-comment")
    public String addComment(@PathVariable("topicId") Long topicId, @PathVariable("postId") Long postId,
                             @Valid @ModelAttribute("newComment") Comment comment, BindingResult bindingResult,
                             Principal principal, Model model) {
        if (bindingResult.hasErrors()) {
            Post post = postService.getPostById(postId);
            post.setTopic(topicService.getTopicById(topicId));
            model.addAttribute("post", post);
            model.addAttribute("comments", commentService.getCommentsByPost(post));
            return "post-details";
        }

        Post post = postService.getPostById(postId);
        comment.setPost(post);
        comment.setAuthor(userService.findByUsername(principal.getName()));
        commentService.createComment(comment);
        return "redirect:/topic/{topicId}/{postId}";
    }
}