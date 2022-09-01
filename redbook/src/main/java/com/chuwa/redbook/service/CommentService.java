package com.chuwa.redbook.service;

import java.util.List;

import com.chuwa.redbook.payload.CommentDto;

public interface CommentService {
    
    CommentDto createCommentDto(Long postId ,CommentDto commentDto);

    List<CommentDto> getCommentByPostId(Long postId);

    CommentDto getCommentById(Long postId, Long commentId);

    CommentDto updatComment(Long postId, Long commentId, CommentDto commentDtoRequest);

    void deleteComment(Long postId, Long commentId);

}
