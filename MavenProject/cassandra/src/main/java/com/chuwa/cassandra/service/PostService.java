package com.chuwa.cassandra.service;

import com.chuwa.cassandra.entity.Post;
import com.chuwa.cassandra.payload.PostDto;

public interface PostService {
    Post createPost(PostDto postDto);
}
