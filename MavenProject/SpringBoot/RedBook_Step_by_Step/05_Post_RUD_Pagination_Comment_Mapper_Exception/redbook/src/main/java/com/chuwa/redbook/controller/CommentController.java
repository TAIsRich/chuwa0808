package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.CommentDto;
import com.chuwa.redbook.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CommentController {
    /**
     * TODO: Questions
     * Why intellij give us this warning? Constructor Injection.
     * How many ways can we do the Dependency Injection?
     * Which way is the best one?
     */
    @Autowired
    private CommentService commentService;

    /**
     * TODO: Questions
     * 当我们浏览小红书时候，点开一篇文章，请问获得这篇文章的内容，是用的哪个API？
     * 看到大家争论库里历史地位是否超越科比，你要写评论回应，当你的评论提交时候，会call哪个API？
     *
     * 此时此刻，思考为什么post的ID是pathVariable而不是request parameter?
     *
     * @param id
     * @param commentDto
     * @return
     */
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") long id,
                                                    @RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(commentService.createComment(id, commentDto), HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable(value = "postId") long postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @GetMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(value = "postId") long postId,
                                                     @PathVariable(value = "id") long commentId) {
        CommentDto commentDto = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<> (commentDto, HttpStatus.OK);
    }

    @PutMapping("posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable(value = "postId") long postId,
                                                    @PathVariable(value = "id") long commentId,
                                                    @RequestBody CommentDto commentDto) {
        CommentDto updatedComment = commentService.updateComment(postId, commentId, commentDto);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "postId") long postId,
                                                @PathVariable(value = "id") long commentId) {
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment is deleted successfully.", HttpStatus.OK);
    }
}
