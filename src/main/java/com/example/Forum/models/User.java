package com.example.Forum.models;

import com.example.Forum.models.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Entity
@Table(name = "usr")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "Ім'я користувача не може бути пустим")
    @Size(max = 30, message = "Максимальна довжина для ім'я користувача - {max} символів")
    @Column(length = 30)
    String username;

    @NotBlank(message = "Пароль не може бути пустим")
    @Size(min = 8, message = "Пароль має містити від {min} символів")
    String password;


    @Transient
    @NotBlank(message = "Пароль не може бути пустим")
    @Length(min = 8, message = "Пароль має містити від {min} символів")
    String confirmPassword;

    boolean active;

    private String adminKey;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
}