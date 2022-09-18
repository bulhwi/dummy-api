package com.example.dummyapi.Posts.service;

import com.example.dummyapi.Posts.model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    WebClient webClient;

    @Value("${json-server}")
    private String jsonServer;

    public ResponseEntity<String> getPosts() {
        return webClient
                .get()
                .uri(jsonServer + "/posts")
                .retrieve()
                .toEntity(String.class)
                .block();
    }
}
