package com.example.Forum.controllers;

import com.example.Forum.models.Topic;
import com.example.Forum.services.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TopicController {
    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/topic")
    public String getAllTopics(Model model) {
        Iterable<Topic> topics = topicService.getAllTopics();
        model.addAttribute("topics", topics);
        return "topic-main";
    }

    @GetMapping("/topic/add")
    public String createTopicForm(Model model) {
        model.addAttribute("topic", new Topic());
        return "topic-add";
    }

    @PostMapping("/topic/add")
    public String createTopicSubmit(@ModelAttribute("topic") Topic topic) {
        topicService.createTopic(topic);
        return "redirect:/topic";
    }
}
