package com.chuwa.redbook.service.Impl;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.exception.SearchNotFoundException;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.PostResponse;
import com.chuwa.redbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto postDto) {

        //convert payload to entity, therefore the dao can store the data into database
//        Post post = new Post();
//        if(postDto.getTitle()!=null){
//            post.setTitle(postDto.getTitle());
//        }else{
//            post.setTitle("");
//        }
//
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());
        //这时候已经成功把request body传递给entity

        //convert DTO to Entity
        Post post = mapToEntity(postDto);

        //调用Dao的save方法，把entity的数据转到数据库Mysql
        //save（）会返回存在数据库中的数据
        Post savePost = postRepository.save(post);

        //将save()返回的数据转换成controller/前端需要的数据，然后return给controller
//        PostDto postResponse = new PostDto();
//        postResponse.setId(savePost.getId());
//        postResponse.setTitle(savePost.getTitle());
//        postResponse.setContent(savePost.getContent());
//        postResponse.setDescription(savePost.getDescription());

        PostDto postResponse = mapToDTO(savePost);

        return postResponse;
    }

    //顺便练习lambda和stream API
    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = posts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir) {
        //Compares this String to another String, ignoring case considerations. Two strings are considered equal ignoring case if they are of the same length and corresponding characters in the two strings are equal ignoring case.
        //Two characters c1 and c2 are considered the same ignoring case if at least one of the following is true:
        //The two characters are the same (as compared by the == operator)
        //Calling Character.toLowerCase(Character.toUpperCase(char)) on each character produces the same result
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                    : Sort.by(sortBy).descending();

        //create pagetable instance
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
//        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
//        PageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        Page<Post> pagePosts = postRepository.findAll(pageRequest);

        //get content for page
        List<Post> posts = pagePosts.getContent();
        List<PostDto> postDtos = posts.stream()
                .map(post -> mapToDTO(post))
                .collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setPageNo(pagePosts.getNumber());
        postResponse.setPageSize(pagePosts.getSize());
        postResponse.setTotalElement(pagePosts.getTotalElements());
        postResponse.setTotalPages(pagePosts.getTotalPages());
        postResponse.setLast(pagePosts.isLast());
        return postResponse;
    }

    //顺便练习了Optional
    @Override
    public PostDto getPostById(long id) {
//        Optional<Post> post = postRepository.findById(id);
//        post.orElseThrow(() -> new ResourceNotFoundException("Post", "id", id)) ;
//
//        Post post = postRepository.findById(id).get();

        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return mapToDTO(post);

    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        //question, why do we need to find it out firstly?
        //b/c we need to find it out at first, after then we are able to update it or edit it
        //otherwise it is not counts as "update"
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        Post updatePost = postRepository.save(post);
        return mapToDTO(updatePost);
    }

    @Override
    public void deletePostById(long id) {
        //  Question, why do we need to find it out firstly?
        // Inorder to delete the certain thing, we need to find it out at first
        // otherwise we cannot delete a random entry or data, it is why we need to throw an exception in case
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);

    }

    @Override
    public List<PostDto> searchByKeyword(String keyword) {
         List<Post> posts = postRepository.findByTitleContainingOrDescriptionContainingOrContentContaining(keyword, keyword, keyword);
         List<PostDto> postDtos = posts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
        return postDtos;
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
