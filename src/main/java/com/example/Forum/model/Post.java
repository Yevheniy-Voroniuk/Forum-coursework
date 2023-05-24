package com.example.Forum.model;

import lombok.Data;


@Data
public class Post {
    private Long postId;
    private String title;
    private String content;
}
