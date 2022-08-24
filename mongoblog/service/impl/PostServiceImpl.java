package com.example.mongoblog.service.impl;

import com.example.mongoblog.dao.PostRepository;
import com.example.mongoblog.entity.Post;
import com.example.mongoblog.payload.PostDto;
import com.example.mongoblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto postDto){
        Post post = new Post();
        if(postDto.getTitle() != null) {
            post.setTitle(postDto.getTitle());
        }else {
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
