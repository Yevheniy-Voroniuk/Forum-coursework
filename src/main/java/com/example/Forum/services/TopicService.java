package com.example.Forum.services;

import com.example.Forum.models.Topic;

import java.util.List;

public interface TopicService {

    void createTopic(Topic topic);

    List<Topic> getAllTopics();

    Topic getTopicById(Long topicId);
}