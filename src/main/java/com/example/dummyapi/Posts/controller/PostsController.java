package com.example.dummyapi.Posts.controller;

import com.example.dummyapi.Posts.model.Posts;
import com.example.dummyapi.Posts.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostsController {
    private final ClientService clientService;

    @GetMapping("/posts")
    public ResponseEntity<String> getPosts() {
        return clientService.getPosts();
    }
}
