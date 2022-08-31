package com.chuwa.cassandra.controller;

import com.chuwa.cassandra.payload.PostDto;
import com.chuwa.cassandra.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        postDto.setId(String.valueOf(postDto.hashCode()));
        return new ResponseEntity(postService.createPost(postDto), HttpStatus.CREATED);
    }
}
