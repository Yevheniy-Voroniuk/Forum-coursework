package com.example.Forum.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "content", nullable = false, length = 2000)
    private String content;

    @ManyToOne
    @JoinColumn(name = "topicId")
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private User author;

    @ManyToOne
    @JoinColumn(name = "parentPostId")
    private Post parentPost;

    @OneToMany(mappedBy = "parentPost", cascade = CascadeType.ALL)
    private List<Post> comments = new ArrayList<>();
}