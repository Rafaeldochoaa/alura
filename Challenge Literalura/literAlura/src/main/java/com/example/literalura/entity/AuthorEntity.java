package com.example.literalura.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import javax.persistence.;
import java.util.List;

@Entity
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int birthYear;
    private int deathYear;

    @OneToMany(mappedBy = "author")
    private List<BookEntity> books;

    // Getters y setters
}
