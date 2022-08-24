package com.example.mongoblog.service;

import com.example.mongoblog.payload.PostDto;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

    PostDto createPost(PostDto postDto);

}
