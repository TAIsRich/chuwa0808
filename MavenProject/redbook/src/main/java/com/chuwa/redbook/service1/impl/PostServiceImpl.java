package com.chuwa.redbook.service1.impl;

import com.chuwa.redbook.dao1.PostRepository;
import com.chuwa.redbook.entity1.Post;
import com.chuwa.redbook.payload1.PostDto;
import com.chuwa.redbook.service1.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto postDto) {
        // 把payload转换成entity，这样才能dao去把该数据存到数据库中
        Post post = new Post();

        if (postDto.getTitle() != null) {
            post.setTitle(postDto.getTitle());
        }
        else {
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
