package com.example.Forum.services;

import com.example.Forum.models.Topic;
import com.example.Forum.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

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

    @Override
    public void updateTopic(Topic updatedTopic) {
        Topic existingTopic = topicRepository.findById(updatedTopic.getTopicId()).orElse(null);
        if (existingTopic != null) {
            existingTopic.setTitle(updatedTopic.getTitle());
            topicRepository.save(existingTopic);
        }
    }

    @Override
    public void deleteTopic(Topic topic) {
        topicRepository.delete(topic);
    }
}