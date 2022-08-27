package com.chuwa.mongoblog.service.Impl;

import com.chuwa.mongoblog.dao.PostRepository;
import com.chuwa.mongoblog.entity.Post;
import com.chuwa.mongoblog.payload.PostDto;
import com.chuwa.mongoblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = mapToEntity(postDto);
        Post savePost = postRepository.save(post);
        PostDto postResponse = mapToDTO(savePost);

        return postResponse;
    }


    private PostDto mapToDTO(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;
    }

    private Post mapToEntity(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        return post;
    }
}
