package com.example.literalura.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import javax.persistence.;
import java.util.List;

@Entity
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String language;
    private int downloadCount;

    @ManyToOne
    private AuthorEntity author;

    // Getters y setters
}
