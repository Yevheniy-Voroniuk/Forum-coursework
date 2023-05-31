package com.example.Forum.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
@Table(name = "topic")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topicId")
    private Long topicId;

    @NotBlank(message = "Тема не може бути пустою")
    @Size(max = 50, message = "Назва теми може містити не більше {max} символів")
    private String title;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.REMOVE)
    private List<Post> posts;
}