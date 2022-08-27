package com.chuwa.mongoblog.service.impl;

import com.chuwa.mongoblog.dao.PostRepository;
import com.chuwa.mongoblog.entity.Post;
import com.chuwa.mongoblog.exception.ResourceNotFoundException;
import com.chuwa.mongoblog.payload.PostDto;
import com.chuwa.mongoblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Override
    public PostDto createPost(PostDto postDto) {
        return mapToDTO(postRepository.save(mapToEntity(postDto)));
    }

    @Override
    public List<PostDto> getAllPost() {
        return postRepository.findAll().stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(String id) {
        return mapToDTO(postRepository.findById(id).orElseThrow(() -> postNotFindException(id)));
    }

    @Override
    public PostDto updatePost(PostDto postDto, String id) {
        Post post = postRepository.findById(id).orElseThrow(() -> postNotFindException(id));
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        return mapToDTO(postRepository.save(post));
    }

    @Override
    public void deletePostById(String id) {
        postRepository.delete(postRepository.findById(id).orElseThrow(() -> postNotFindException(id)));
    }

    private PostDto mapToDTO(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());

        return postDto;
    }

    private Post mapToEntity(PostDto postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        return post;
    }

    private static ResourceNotFoundException postNotFindException(String id) {
        return new ResourceNotFoundException("Post", "id", id);
    }
}
