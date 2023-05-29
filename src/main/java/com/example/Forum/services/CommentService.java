package com.example.Forum.services;

import com.example.Forum.models.Comment;
import com.example.Forum.models.Post;

import java.util.List;

public interface CommentService {
    void createComment(Comment comment);
    List<Comment> getCommentsByPost(Post post);
}