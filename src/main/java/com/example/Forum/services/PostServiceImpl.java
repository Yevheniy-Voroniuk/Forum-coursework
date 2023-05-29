package com.example.Forum.services;

import com.example.Forum.models.Post;
import com.example.Forum.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public void createPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public List<Post> getAllPostsByTopic(Long topicId) {
        return postRepository.findByTopicTopicId(topicId);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }
}