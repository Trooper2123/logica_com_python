package com.backend.vote.user;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "tb_user")
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String document;

}
