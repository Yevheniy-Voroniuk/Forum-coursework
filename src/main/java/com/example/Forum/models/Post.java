package com.example.Forum.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "postId")
    private Long postId;
    @Column(name="title", nullable = false, length = 50)
    private String title;
    @Column(name="content", nullable = false, length = 500)
    private String content;
}


