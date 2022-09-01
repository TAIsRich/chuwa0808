package com.chuwa.redbook2.controller;

import com.chuwa.redbook2.payload.PostDto;
import com.chuwa.redbook2.payload.PostResponse;
import com.chuwa.redbook2.service.PostService;
import com.chuwa.redbook2.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;//用autowire将service注入进来

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto postResponse = postService.createPost(postDto);
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);//201
    }

    //PRACTICE exercise
    @GetMapping("/search")
    public PostResponse searchByContentContains(@RequestParam("keyword") String content){
        return postService.searchPostByContentContains(content);
    }
    //http://localhost:8080/api/v1/posts/search?keyword=test
    //RequestParam vs Pathvariable
    //reference link: https://javarevisited.blogspot.com/2017/10/differences-between-requestparam-and-pathvariable-annotations-spring-mvc.html#axzz7dNwUpc2o

    /*@GetMapping("/countByContentOrDescrp")
    public long countPostsByDescriptionOrContentContains(@RequestParam("keyword") String key){
        return postService.countPostsByContentOrDescrp(key);
    }*/

    @GetMapping
    //public List<PostDto> getAllPosts(){
      //  return postService.getAllPost();
    //}
    public PostResponse getAllPost(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIR, required = false) String sortDir
    ){
        return postService.getAllPost(pageNo, pageSize, sortBy, sortDir);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id){ //将annotation上"id"传进的内容作为input: id
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable(name = "id") long id){
        PostDto postResponse = postService.updatePost(postDto, id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("Post entity deleted successfully", HttpStatus.OK);

    }


}
