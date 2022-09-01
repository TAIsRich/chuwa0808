package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto p);

    List<PostDto> getPosts();

    PostDto getPostById(Long id);

    PostDto updatePost(PostDto postDto, Long id);

    void deletePostById(Long id);

    List<PostDto> getAllPost();

    PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);

}
