package com.example.Forum.controllers;

import com.example.Forum.models.Topic;
import com.example.Forum.services.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class TopicController {
    private final TopicService topicService;

    @Autowired
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
    public String createTopicSubmit(@Valid @ModelAttribute Topic topic, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "topic-add";
        }
        topicService.createTopic(topic);
        return "redirect:/topic";
    }

    @GetMapping("/topic/{topicId}/edit")
    public String editTopicForm(@PathVariable("topicId") Long topicId, Model model) {
        Topic topic = topicService.getTopicById(topicId);
        model.addAttribute("topic", topic);
        return "topic-edit";
    }

    @PostMapping("/topic/{topicId}/edit")
    public String editTopicSubmit(@PathVariable("topicId") Long topicId, @Valid @ModelAttribute("topic") Topic updatedTopic, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "topic-edit";
        }
        Topic topic = topicService.getTopicById(topicId);
        topic.setTitle(updatedTopic.getTitle());
        topicService.updateTopic(topic);
        return "redirect:/topic";
    }


    @PostMapping("/topic/{topicId}/remove")
    public String deleteTopic(@PathVariable("topicId") Long topicId) {
        Topic topic = topicService.getTopicById(topicId);
        topicService.deleteTopic(topic);
        return "redirect:/topic";
    }
}