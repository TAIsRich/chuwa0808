package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.PostResponse;

import java.util.List;

public interface PostService {
    // POST
    PostDto createPost(PostDto postDto);

    // GET
    List<PostDto> getAllPosts();

    /**
     * 分页
     * @param pageNo
     * @param pageSize
     * @param sortBy
     * @param sortDir
     * @return
     */
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(long id);

    // PUT
    PostDto updatePostById(PostDto postDto, long id);

    // DELETE
    void deletePostById(long id);
}
