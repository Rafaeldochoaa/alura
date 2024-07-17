package com.example.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {
    private String name;
    private int birth_year;
    private int death_year;

    // Getters y setters
}
