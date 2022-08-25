package com.chuwa.mongoblog.service;

import com.chuwa.mongoblog.payload.PostDto;
import com.chuwa.mongoblog.payload.PostResponse;
import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPost();

    PostDto getPostById(String id);

    PostDto updatePost(PostDto postDto, String id);

    void deletePostById(String id);

    PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);
}
