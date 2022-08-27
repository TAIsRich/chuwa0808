package com.chuwa.mongoblog.service.impl;

import com.chuwa.mongoblog.dao.PostRepository;
import com.chuwa.mongoblog.entity.Post;
import com.chuwa.mongoblog.payload.PostDto;
import com.chuwa.mongoblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;

public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto postDto) {
        //payload to entity/document
        Post post = new Post();
        if(postDto.getTitle() != null) post.setTitle(postDto.getTitle());
        else post.setTitle("");

        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        //save doc to database(mongoDb in this case)
        Post savedPost = postRepository.save(post);

        //read from mdb and return a postDto to the client
        PostDto postResponse = new PostDto();
        postResponse.setId(savedPost.getId());
        postResponse.setContent(savedPost.getContent());
        postResponse.setDescription(savedPost.getDescription());
        postResponse.setTitle(savedPost.getTitle());

        return postResponse;
    }
}
