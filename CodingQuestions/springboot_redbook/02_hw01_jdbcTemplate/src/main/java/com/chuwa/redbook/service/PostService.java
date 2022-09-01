package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.PostDto;

import java.util.List;

/**
 * @author b1go
 * @date 8/22/22 6:51 PM
 */
public interface PostService {

    PostDto createPost(PostDto postDto) throws Exception;

    List<PostDto> getAllPost() throws Exception;

    PostDto getPostById(long id) throws Exception;

    PostDto updatePost(PostDto postDto, long id) throws Exception;

    void deletePostById(long id) throws Exception;
}
