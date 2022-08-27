package com.chuwa.cassandra.test.service;

import com.chuwa.cassandra.test.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto p);
    PostDto getPostById(int id);
}
