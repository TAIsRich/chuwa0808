package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Flora Zhong
 * @date 8/23/22
 */

@RestController
@RequestMapping("/api/v1")
public class PostController {
    // Spring Dependency Injection: https://www.geeksforgeeks.org/spring-dependency-injection-with-example/
    // fields are injected right after construction of a bean, before any config methods are invoked
    // such a config field does not have to be public
    @Autowired
    private PostService postService;

    // 这里不写("/posts")，放在上面一起写也行：@RequestMapping("/api/v1/posts")
    @PostMapping("/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto postResponse = postService.createPost(postDto);
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }



}
