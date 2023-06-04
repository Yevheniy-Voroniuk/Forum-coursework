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

    @Pattern(regexp = "^(?=.*[a-zA-Z])[a-zA-Z0-9]{3,40}$",
            message = "Username must contain at least one letter and can consist of 3-40 characters")
    @NotBlank(message = "Username cannot be empty")
    @Size(max = 40, message = "Maximum username length is {max} characters")
    @Column(length = 40)
    String username;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 8, message = "Password must contain at least {min} characters")
    String password;

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