package com.example.Forum.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postId")
    private Long postId;

    @Size(max = 200, message = "Maximum length is {max} characters")
    @Column(name = "title")
    private String title;

    @NotBlank(message = "Content cannot be empty")
    @Size(max = 2000, message = "Maximum length is {max} characters")
    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "topicId")
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private User author;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();
}