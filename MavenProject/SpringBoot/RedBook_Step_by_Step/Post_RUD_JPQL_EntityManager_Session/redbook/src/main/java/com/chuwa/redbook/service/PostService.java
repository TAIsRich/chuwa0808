package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.PostDto;

import java.util.List;

public interface PostService {
    // POST
    PostDto createPost(PostDto postDto);

    // GET
    List<PostDto> getAllPosts();
    PostDto getPostById(long id);

    // PUT
    PostDto updatePostById(PostDto postDto, long id);

    // DELETE
    void deletePostById(long id);

    List<PostDto> getAllPostsWithJPQL();
    PostDto getPostByIdJPQLIndexParameter(Long id, String title);
    PostDto getPostByIdJPQLNamedParameter(Long id, String title);
    PostDto getPostByIdSQLIndexParameter(Long id, String title);
    PostDto getPostByIdSQLNamedParameter(Long id, String title);
}
