package com.chuwa.demoOfMongo.service.impl;

//import com.chuwa.demoOfMongo.dao.PostRepository;
import com.chuwa.demoOfMongo.dao.PostRepository;
import com.chuwa.demoOfMongo.entity.Post;
import com.chuwa.demoOfMongo.payload.PostDto;
import com.chuwa.demoOfMongo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto p) {
        Post post = new Post();
        post.setTitle(p.getTitle());
        post.setContent(p.getContent());
        post.setDescription(p.getDescription());

        Post savedPost = postRepository.save(post);
        PostDto postResponse = new PostDto();
        postResponse.setContent(savedPost.getContent());
        postResponse.setDescription(savedPost.getDescription());
        postResponse.setId(savedPost.getId());
        postResponse.setTitle(savedPost.getTitle());

        return postResponse;

    }
}
