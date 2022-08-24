package com.chuwa.demo.service.impl;

import com.chuwa.demo.dao.PostRepository;
import com.chuwa.demo.entity.Post;
import com.chuwa.demo.payload.PostDto;
import com.chuwa.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    public PostDto createPost(PostDto postDto) {
        // transform payload to entity
        Post post = new Post();
        if (postDto.getTitle() != null){
            post.setTitle(postDto.getTitle());
        } else {
            post.setTitle("");
        }

        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post savedPost = postRepository.save(post);

        PostDto postResponse = new PostDto();
        postResponse.setId(savedPost.getId());
        postResponse.setTitle(savedPost.getTitle());
        postResponse.setDescription(savedPost.getDescription());
        postResponse.setContent(savedPost.getContent());
        return postResponse;
    }
}
