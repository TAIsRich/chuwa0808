package com.chuwa.mongoblog.service;

import com.chuwa.mongoblog.payload.PostDto;

public interface PostService {

    PostDto createPost(PostDto postDto);
}
