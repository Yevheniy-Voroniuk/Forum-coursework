package com.example.Forum.services;

import com.example.Forum.models.Comment;
import com.example.Forum.models.Post;
import com.example.Forum.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void createComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentsByPost(Post post) {
        return commentRepository.findByPost(post);
    }
}