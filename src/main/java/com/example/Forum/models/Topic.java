package com.example.Forum.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Table(name = "topics")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topicId")
    private Long topicId;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private List<Post> posts;
}
