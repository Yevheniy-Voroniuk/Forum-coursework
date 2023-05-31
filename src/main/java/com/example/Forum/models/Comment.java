package com.example.Forum.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @NotBlank(message = "Не можна залишати пустий коментар")
    @Length(max = 1000, message = "Коментар може містити не більше {max} символів")
    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private User author;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;
}