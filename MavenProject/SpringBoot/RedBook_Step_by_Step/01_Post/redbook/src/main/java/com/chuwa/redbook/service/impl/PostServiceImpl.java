package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    // Spring Dependency Injection: https://www.geeksforgeeks.org/spring-dependency-injection-with-example/
    // fields are injected right after construction of a bean, before any config methods are invoked
    // such a config field does not have to be public
    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto postDto) {
        // 把payload转换成entity，这样才能Dao去把该数据存到数据库中
        Post post = new Post();

        if (postDto.getTitle() != null) {
            post.setTitle(postDto.getTitle());
        }
        else {
            post.setTitle("");
        }
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        // 此时已成功把request body的信息传递给entity

        // 调用Dao的save方法，将entity的数据存储到数据库MySQL
        // save()会返回存储在数据库中的数据
        Post savedPost = postRepository.save(post);

        // 将save()返回的数据转换成controller/前端所需要的数据，然后return给controller
        PostDto postResponse = new PostDto();
        postResponse.setTitle(savedPost.getTitle());
        postResponse.setDescription(savedPost.getDescription());
        postResponse.setContent(savedPost.getContent());

        return postResponse;
    }
}
