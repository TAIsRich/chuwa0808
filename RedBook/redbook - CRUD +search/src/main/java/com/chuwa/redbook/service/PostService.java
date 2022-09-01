package com.chuwa.redbook.service;

import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPst(PostDto postDto);

    List<PostDto> getAllPosts();

    PostDto getPostById(long id);

    PostDto updatPost(PostDto postDto, long id);

    void deletePostById(long id);

    List<PostDto> searchPost(String keyword);
}
