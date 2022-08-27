package com.chuwa.redbook2.service;

import com.chuwa.redbook2.payload.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto createComment(long postId, CommentDto commentDto);
    List<CommentDto> getCommentsByPostId(long postId);
    CommentDto getCommentById(Long postId, Long commetId);
    CommentDto updateComment(long postId, Long commentId, CommentDto commentDtoRequest);
    void deleteComment(Long postId, Long commentId);


}
