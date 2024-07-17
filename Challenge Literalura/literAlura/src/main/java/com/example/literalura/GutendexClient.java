package com.example.literalura;

import java.awt.print.Book;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class GutendexClient {

    private static final String BASE_URL = "https://gutendex.com/books/";

    public String searchBookByTitle(String title) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String url = BASE_URL + "?title=" + title;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
    private ObjectMapper objectMapper;

    public GutendexClient() {
        this.objectMapper = new ObjectMapper();
    }

    public Book getBookFromJson(String json) throws IOException {
        return objectMapper.readValue(json, Book.class);
    }
}

