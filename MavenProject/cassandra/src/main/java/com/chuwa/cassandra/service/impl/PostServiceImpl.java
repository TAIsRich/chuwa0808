package com.chuwa.cassandra.service.impl;

import com.chuwa.cassandra.dao.PostRepository;
import com.chuwa.cassandra.entity.Post;
import com.chuwa.cassandra.exception.ResourceNotFoundException;
import com.chuwa.cassandra.payload.PostDto;
import com.chuwa.cassandra.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post createPost(PostDto postDto) {
        return postRepository.save(mapToEntity(postDto));
    }

    private static PostDto mapToDTO(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());

        return postDto;
    }

    private static Post mapToEntity(PostDto postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        return post;
    }

    static ResourceNotFoundException postNotFindException(long id) {
        return new ResourceNotFoundException("Post", "id", id);
    }
}
