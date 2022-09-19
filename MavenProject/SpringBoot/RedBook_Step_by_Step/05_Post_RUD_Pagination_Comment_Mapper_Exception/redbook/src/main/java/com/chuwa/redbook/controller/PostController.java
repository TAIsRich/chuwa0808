package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.PostResponse;
import com.chuwa.redbook.service.PostService;
import com.chuwa.redbook.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Flora Zhong
 * @date 8/27/22
 */

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    // Spring Dependency Injection: https://www.geeksforgeeks.org/spring-dependency-injection-with-example/
    // fields are injected right after construction of a bean, before any config methods are invoked
    // such a config field does not have to be public
    @Autowired
    private PostService postService;

    // 这里写@PostMapping("/posts")，上面写@RequestMapping("/api/v1")不行，因为下面@GetMapping("/{id}")用到path: /api/v1/posts
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto postResponse = postService.createPost(postDto);
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }

    /*
    @GetMapping
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }
    */

    // use request parameter
    @GetMapping
    public PostResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIR, required = false) String sortDir
    ) {
        return postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }

    // use request path variable
    // 用ResponseEntity<PostDto>将PostDto package起来，在Postman的response console里看到的数据更整齐、可读性更强，可以试验一下不package, 看看response data的呈现形式
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    // use request path variable
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable(name = "id") long id) {
        PostDto postResponse = postService.updatePostById(postDto, id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    // use request path variable
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable(name = "id") long id) {
        postService.deletePostById(id);
        return new ResponseEntity<>(String.format("Post entity with %d is deleted successfully.", id), HttpStatus.OK);
    }
}
