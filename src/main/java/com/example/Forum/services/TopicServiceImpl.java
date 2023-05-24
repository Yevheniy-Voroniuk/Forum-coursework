package com.example.Forum.services;

import com.example.Forum.models.Topic;
import com.example.Forum.repositories.TopicRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    @Override
    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Override
    public Topic updateTopic(Long topicId, Topic updatedTopic) {
        Optional<Topic> existingTopicOptional = topicRepository.findById(topicId);
        if (existingTopicOptional.isPresent()) {
            Topic existingTopic = existingTopicOptional.get();
            existingTopic.setTitle(updatedTopic.getTitle());
            return topicRepository.save(existingTopic);
        }
        return null;
    }

    @Override
    public void deleteTopic(Long topicId) {
        topicRepository.deleteById(topicId);
    }

    @Override
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }
}
