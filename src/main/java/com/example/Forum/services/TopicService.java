package com.example.Forum.services;

import com.example.Forum.models.Topic;

import java.util.List;

public interface TopicService {
    Topic createTopic(Topic topic);
    Topic updateTopic(Long topicId, Topic updatedTopic);
    void deleteTopic(Long topicId);
    List<Topic> getAllTopics();
}
