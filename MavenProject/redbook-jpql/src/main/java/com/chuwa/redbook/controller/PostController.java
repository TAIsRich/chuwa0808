package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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
        PostDto postResponse = postService.createPost(postDto);
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public List<PostDto> getAllPosts() {
        return postService.getAllPost();
    }

    @GetMapping("/jpql")
    public List<PostDto> getAllPostsJPQL() {
        return postService.getAllPost();
    }

    @GetMapping("/jpql-index/{id}")
    public ResponseEntity<PostDto> getPostByIdOrTitleJPQLIndex(
            @PathVariable(name = "id") long id,
            @RequestParam(value = "title", required = false)
            String title) {
        return ResponseEntity.ok(postService.getPostByIdJPQLIndexParameter(id, title));
    }

    @GetMapping("/jpql-named/{id}")
    public ResponseEntity<PostDto> getPostByIdOrTitleJPQLNamed(
            @PathVariable(name = "id") long id,
            @RequestParam(value = "title", required = false) String title) {
        return ResponseEntity.ok(postService.getPostByIdJPQLNamedParameter(id, title));
    }

    @GetMapping("/sql-index/{id}")
    public ResponseEntity<PostDto> getPostByIdOrTitleSQLIndex(
            @PathVariable(name = "id") long id,
            @RequestParam(value = "title", required = false) String title) {
        return ResponseEntity.ok(postService.getPostByIdSQLIndexParameter(id, title));
    }

    @GetMapping("/sql-named/{id}")
    public ResponseEntity<PostDto> getPostByIdOrTitleSQLParameter(
            @PathVariable(name = "id") long id,
            @RequestParam(value = "title", required = false) String title) {
        return ResponseEntity.ok(postService.getPostByIdSQLNamedParameter(id, title));
    }
}
