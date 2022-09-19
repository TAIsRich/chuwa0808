package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.PostDto;

import java.util.List;

public interface PostService {
    // POST
    PostDto createPost(PostDto postDto);

    // GET
    List<PostDto> getAllPosts();
    PostDto getPostById(long id);

    List<PostDto> searchByKeyword(String keyword);

    // PUT
    PostDto updatePostById(PostDto postDto, long id);

    // DELETE
    void deletePostById(long id);
}
