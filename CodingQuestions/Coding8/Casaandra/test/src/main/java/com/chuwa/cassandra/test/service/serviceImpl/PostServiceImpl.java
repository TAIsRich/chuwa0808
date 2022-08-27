package com.chuwa.cassandra.test.service.serviceImpl;

import com.chuwa.cassandra.test.entity.Post;
import com.chuwa.cassandra.test.payload.PostDto;
import com.chuwa.cassandra.test.repository.PostRepository;
import com.chuwa.cassandra.test.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto p) {
        Post post = mapToEntity(p);
        Post post1 = postRepository.save(post);

        return mapToDTO(post1);
    }

    @Override
    public PostDto getPostById(int id) {
        Post post = postRepository.findById(id).get();

        return mapToDTO(post);
    }

    private PostDto mapToDTO(Post post) {
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
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        return post;
    }


}
