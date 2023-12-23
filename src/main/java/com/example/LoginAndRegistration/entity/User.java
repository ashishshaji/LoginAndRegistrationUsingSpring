package com.example.LoginAndRegistration.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false, unique=true)
    private  String userName;

    @Column(nullable=false)
    private  String password;

    @Email
    @Column(nullable = false, unique=true)
    private String email;

}
