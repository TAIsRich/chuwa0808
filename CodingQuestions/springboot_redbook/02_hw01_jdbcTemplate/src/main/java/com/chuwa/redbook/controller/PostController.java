package com.chuwa.redbook.controller;

import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author b1go
 * @date 8/22/22 7:14 PM
 */
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto postResponse = null;
        try {
            postResponse = postService.createPost(postDto);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Post", "id", postDto.getId());
        }
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public List<PostDto> getAllPosts() {
        try {
            return postService.getAllPost();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id) {
        try {
            return ResponseEntity.ok(postService.getPostById(id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Post", "id", id);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable(name = "id") long id) {
        PostDto postResponse = null;
        try {
            postResponse = postService.updatePost(postDto, id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Post", "id", id);
        }
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id) {
        try {
            postService.deletePostById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Post", "id", id);
        }
        return new ResponseEntity<>("Post entity deleted successfully.", HttpStatus.OK);
    }

}
