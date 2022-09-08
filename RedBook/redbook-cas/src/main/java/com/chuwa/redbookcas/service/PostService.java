package com.chuwa.redbookcas.service;

import com.chuwa.redbookcas.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();
}
