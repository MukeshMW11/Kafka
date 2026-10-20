package com.mw.pub.entities;


import com.mw.pub.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    private String name;
    @Column(unique = true, nullable = false )
    private String email;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;


}
