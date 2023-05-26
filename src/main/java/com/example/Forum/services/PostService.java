package com.example.Forum.services;

import com.example.Forum.models.Post;

import java.util.List;

public interface PostService {
    void createPost(Post post);

    List<Post> getAllPostsByTopic(Long topicId);

    List<Post> getAllPosts();
}
