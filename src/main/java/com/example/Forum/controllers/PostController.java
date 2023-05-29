package com.example.Forum.controllers;

import com.example.Forum.models.Comment;
import com.example.Forum.models.Post;
import com.example.Forum.models.Topic;
import com.example.Forum.models.User;
import com.example.Forum.services.PostService;
import com.example.Forum.services.TopicService;
import com.example.Forum.services.UserService;
import com.example.Forum.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class PostController {

    private final PostService postService;
    private final TopicService topicService;
    private final UserService userService;
    private final CommentService commentService;

    @Autowired
    public PostController(PostService postService, TopicService topicService, UserService userService, CommentService commentService) {
        this.postService = postService;
        this.topicService = topicService;
        this.userService = userService;
        this.commentService = commentService;
    }

    @GetMapping("/topic/{topicId}/add")
    public String createPost(@PathVariable("topicId") Long topicId, Model model) {
        model.addAttribute("topicId", topicId);
        model.addAttribute("post", new Post());
        return "post-add";
    }

    @PostMapping("/topic/{topicId}/add")
    public String createPostSubmit(@PathVariable("topicId") Long topicId, @ModelAttribute Post post, Principal principal) {
        Topic topic = topicService.getTopicById(topicId);
        User author = userService.findByUsername(principal.getName());
        post.setTopic(topic);
        post.setAuthor(author);
        postService.createPost(post);
        return String.format("redirect:/topic/%d", topicId);
    }

    @GetMapping("/topic/{topicId}")
    public String showPostsByTopic(@PathVariable("topicId") Long topicId, Model model) {
        List<Post> postsByTopic = postService.getAllPostsByTopic(topicId);
        model.addAttribute("posts", postsByTopic);
        return "posts-by-topic";
    }

    @GetMapping("/posts")
    public String showAllPosts(Model model) {
        List<Post> allPosts = postService.getAllPosts();
        model.addAttribute("posts", allPosts);
        return "all-posts";
    }

    @GetMapping("/topic/{topicId}/{postId}")
    public String showPostDetails(@PathVariable("topicId") Long topicId, @PathVariable("postId") Long postId, Model model) {
        Post post = postService.getPostById(postId);
        post.setTopic(topicService.getTopicById(topicId));
        List<Comment> comments = commentService.getCommentsByPost(post);
        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        model.addAttribute("newComment", new Comment());
        return "post-details";
    }
}