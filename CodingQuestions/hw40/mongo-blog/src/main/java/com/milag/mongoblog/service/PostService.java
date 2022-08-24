package com.milag.mongoblog.service;

import com.milag.mongoblog.payload.PostDto;

public interface PostService {

    PostDto createPost(PostDto postDto);
}
