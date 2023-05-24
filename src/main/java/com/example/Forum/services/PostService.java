package com.example.Forum.services;

import com.example.Forum.models.Post;

public interface PostService {
    Post createPost(Post post);
    void deletePost(Long postId);
}
