package com.SuShef.backend.login.service;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    @NonNull
    private String password;
//    @NonNull
    private String email;
//    @NonNull
    private Role role;
    private String phone;
}


