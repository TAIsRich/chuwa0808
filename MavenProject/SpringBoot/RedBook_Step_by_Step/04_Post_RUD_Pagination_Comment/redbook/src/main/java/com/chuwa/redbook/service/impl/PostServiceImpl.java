package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.PostResponse;
import com.chuwa.redbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    // Spring Dependency Injection: https://www.geeksforgeeks.org/spring-dependency-injection-with-example/
    // fields are injected right after construction of a bean, before any config methods are invoked
    // such a config field does not have to be public
    @Autowired
    private PostRepository postRepository;

    // POST
    @Override
    public PostDto createPost(PostDto postDto) {
        // 把payload转换成entity，这样才能Dao去把该数据存到数据库中
        /*
        Post post = new Post();

        if (postDto.getTitle() != null) {
            post.setTitle(postDto.getTitle());
        }
        else {
            post.setTitle("");
        }
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        */
        // 此时已成功把request body的信息传递给entity

        // convert Dto to Entity
        Post post = mapToEntity(postDto);

        // 调用Dao的save方法，将entity的数据存储到数据库MySQL
        // save()会返回存储在数据库中的数据
        Post savedPost = postRepository.save(post);

        // 将save()返回的数据转换成controller/前端所需要的数据，然后return给controller
        /*
        PostDto postResponse = new PostDto();
        postResponse.setTitle(savedPost.getTitle());
        postResponse.setDescription(savedPost.getDescription());
        postResponse.setContent(savedPost.getContent());
        */
        PostDto postResponse = mapToDto(savedPost);

        return postResponse;
    }

    /**
     * 此处顺便练习了lambda, stream API
     * @return
     */
    // GET
    @Override
    public List<PostDto> getAllPosts() {
        // 在Spring frame中，findAll()是interface JpaRepository<T, ID> which is extended by our interface PostRepository自有的abstract method，由Hibernate实现，our PostRepository object可以直接调用
        List<Post> posts = postRepository.findAll();

        List<PostDto> postDtos = posts.stream()
                .map(post -> mapToDto(post))
                .collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        // compare this String to another String, ignoring case consideration:
        // two strings are considered equal ignoring case if they are of the same length and the corresponding characters in the two strings are equal ignoring case
        // two characters c1 and c2 are considered same ignoring case if one of the followings is true at least:
        // c1 and c2 are same (as compared by the == operator)
        // calling Character.toLowerCase(c) / Character.toUpperCase(c) on each character produces the same result
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        // 3种写法to create pageable instance:
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
        // PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        // PageRequest pageRequest2 = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Post> pagePosts = postRepository.findAll(pageRequest);

        // get content for page
        List<Post> posts = pagePosts.getContent();
        // convert Post to PostDto
        List<PostDto> postDtos = posts.stream()
                .map(post -> mapToDto(post))
                .collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setTotalElements(pagePosts.getTotalElements());
        postResponse.setPageSize(pagePosts.getSize());
        postResponse.setTotalPages(pagePosts.getTotalPages());
        postResponse.setPageNo(pagePosts.getNumber());
        postResponse.setLast(pagePosts.isLast());

        return postResponse;
    }

    /**
     * 此处顺便练习了Optional
     * @param id
     * @return
     */
    // GET
    @Override
    public PostDto getPostById(long id) {
        /*
        Optional<Post> optional = postRepository.findById(id);
        optional.orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        */
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        return mapToDto(post);
    }

    // PUT
    @Override
    public PostDto updatePostById(PostDto postDto, long id) {
        // why do we need to find it out firstly?
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post updatedPost = postRepository.save(post);

        return mapToDto(updatedPost);
    }

    // DELETE
    @Override
    public void deletePostById(long id) {
        // why do we need to find it out firstly?
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
    }

    private Post mapToEntity(PostDto postDto) {
        Post post = new Post();

        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        return post;
    }

    private PostDto mapToDto(Post post) {
        PostDto postDto = new PostDto();

        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());

        return postDto;
    }
}
