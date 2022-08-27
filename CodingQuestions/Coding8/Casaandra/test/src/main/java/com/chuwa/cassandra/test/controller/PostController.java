package com.chuwa.cassandra.test.controller;

import com.chuwa.cassandra.test.payload.PostDto;
import com.chuwa.cassandra.test.repository.PostRepository;
import com.chuwa.cassandra.test.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/postapi")
public class PostController {
//    PostRepository postRepository;
    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable(name = "id") int id){
        return null;
    }

    @PostMapping()
    public ResponseEntity<PostDto>  uploadPost(@RequestBody PostDto postDto){
        PostDto pd = postService.createPost(postDto);
        return new ResponseEntity<>(pd,HttpStatus.CREATED);
    }

}
