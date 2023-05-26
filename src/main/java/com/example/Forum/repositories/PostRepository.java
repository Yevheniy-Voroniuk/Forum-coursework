package com.example.Forum.repositories;

import com.example.Forum.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTopicTopicId(Long topicId);
}