package com.chuwa.demoOfMongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chuwa.demoOfMongo.payload.PostDto;
import com.chuwa.demoOfMongo.service.PostService;

@RestController
@RequestMapping("/api/v1")
public class postController {

    @Autowired
    private PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto postRes = postService.createPost(postDto);
        return new ResponseEntity<>(postRes, HttpStatus.CREATED);
    }

}
