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

    @NotBlank(message = "Username cannot be empty")
    @Size(max = 30, message = "Maximum username length is {max} characters")
    @Column(length = 30)
    String username;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 8, message = "Password must contain at least {min} characters")
    String password;

    @Transient
    @NotBlank(message = "Confirm password cannot be empty")
    @Length(min = 8, message = "Confirm password must contain at least {min} characters")
    String confirmPassword;

    boolean active;

    private String adminKey;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
}
