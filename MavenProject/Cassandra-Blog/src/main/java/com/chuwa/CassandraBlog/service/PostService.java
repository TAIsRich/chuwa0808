package com.chuwa.CassandraBlog.service;

import com.chuwa.CassandraBlog.payload.PostDto;

import java.util.List;
import java.util.UUID;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPost();

    PostDto getPostById(UUID id);

    PostDto updatePost(PostDto postDto, UUID id);

    void deletePostById(UUID id);
}
