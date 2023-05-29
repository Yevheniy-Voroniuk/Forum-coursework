package com.example.Forum.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;

    private String content;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private User author;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;
}