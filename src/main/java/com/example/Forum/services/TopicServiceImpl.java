package com.example.Forum.services;

import com.example.Forum.models.Topic;
import com.example.Forum.repositories.TopicRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    @Override
    public void createTopic(Topic topic) {
        topicRepository.save(topic);
    }

    @Override
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @Override
    public Topic getTopicById(Long topicId) {
        return topicRepository.findById(topicId).orElse(null);
    }
}