package com.example.Forum.controllers;

import com.example.Forum.models.Post;
import com.example.Forum.models.Topic;
import com.example.Forum.services.PostService;
import com.example.Forum.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class PostController {

    private final PostService postService;

    private final TopicService topicService;

    @Autowired
    public PostController(PostService postService, TopicService topicService) {
        this.postService = postService;
        this.topicService = topicService;
    }

    @GetMapping("/topic/{topicId}/add")
    public String createPost(@PathVariable("topicId") Long topicId, Model model) {
        model.addAttribute("topicId", topicId);
        model.addAttribute("post", new Post());
        return "post-add";
    }

    @PostMapping("/topic/{topicId}/add")
    public String createPostSubmit(@PathVariable("topicId") Long topicId, @ModelAttribute Post post) {
        Topic topic = topicService.getTopicById(topicId);
        post.setTopic(topic);
        postService.createPost(post);
        return String.format("redirect:/topic/{topicId}", topicId);
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
}