package com.chuwa.redbook.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.chuwa.redbook.dao.PostJPQLRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.PostResponse;
import com.chuwa.redbook.service.PostService;




@Service
public class PostServiceImpl implements PostService{
    
    private static final Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);
    
    @Autowired 
    private PostRepository postRepository;

    @Autowired
    private PostJPQLRepository postJPQLRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostDto postDto){

       Post post = modelMapper.map(postDto, Post.class);

       Post savedPost = postRepository.save(post);

       return modelMapper.map(savedPost, PostDto.class);

    }

    @Override
    public void deletePostById(long id) {
        //  Question, why do we need to find it out firstly?
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id){
      Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
      post.setTitle(postDto.getTitle());
      post.setDescription(postDto.getDescription());
      post.setContent(postDto.getContent());

      Post updatePost = postRepository.save(post);
      return modelMapper.map(updatePost, PostDto.class);
    }


    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    /**
     * 此处顺便练习Optional
     * @param id
     * @return
     */
    @Override
    public PostDto getPostById(long id) {
//        Optional<Post> post = postRepository.findById(id);
//        post.orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

//        Post post = postRepository.findById(id).get();

        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir) {

        logger.info("service getAllPost with pageable are called");
        logger.info("creating a sort object");
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create pageable instance
        logger.info("creating a PageRequest object");
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
//        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
//        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        logger.info("calling postRepository to get the data from database");
        Page<Post> pagePosts = postRepository.findAll(pageRequest);

        // get content for page abject
        logger.info("Fetching data successfully and converting data to Dtos");
        List<Post> posts = pagePosts.getContent();
        List<PostDto> postDtos = posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

        logger.info("adding meta data to the response");
        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setPageNo(pagePosts.getNumber());
        postResponse.setPageSize(pagePosts.getSize());
        postResponse.setTotalElements(pagePosts.getTotalElements());
        postResponse.setTotalPages(pagePosts.getTotalPages());
        postResponse.setLast(pagePosts.isLast());
        return postResponse;
    }


    @Override
    public List<PostDto> findByTitleLike(String title){
        List<Post> posts = postRepository.findByTitleLike(title);
        return posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getAllPostWithJPQL() {
        return postJPQLRepository.getAllPostWithJPQL().stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostByIdJPQLIndexParameter(Long id, String title) {
        Post post = postRepository.getPostByIDOrTitleWithJPQLIndexParameters(id, title);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public PostDto getPostByIdJPQLNamedParameter(Long id, String title) {
        Post post = postRepository.getPostByIDOrTitleWithJPQLNamedParameters(id, title);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public PostDto getPostByIdSQLIndexParameter(Long id, String title) {
        Post post = postRepository.getPostByIDOrTitleWithSQLIndexParameters(id, title);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public PostDto getPostByIdSQLNamedParameter(Long id, String title) {
        Post post = postRepository.getPostByIDOrTitleWithSQLNamedParameters(id, title);
        return modelMapper.map(post, PostDto.class);
    }



    // private PostDto mapToDTO(Post post){

    //   PostDto postDto = new PostDto();

    //   postDto.setId(post.getId());

    //   postDto.setDescription(post.getDescription());

    //   postDto.setTitle(post.getTitle());

    //   postDto.setContent(post.getContent());

    //   return postDto;
    // }
 

    // private Post mapToEntity(PostDto postDto){

    //     Post post = new Post();

    //     post.setTitle(postDto.getTitle());

    //     post.setDescription(postDto.getDescription());

    //     post.setContent(postDto.getContent());

    //     return post;
    // }
}