package com.chuwa.redbook2.service.impl;

import com.chuwa.redbook2.dao.PostRepository;
import com.chuwa.redbook2.entity.Post;
import com.chuwa.redbook2.exception.ResourceNotFoundException;
import com.chuwa.redbook2.payload.PostDto;
import com.chuwa.redbook2.payload.PostResponse;
import com.chuwa.redbook2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service //呼应controller下面的@Autowired
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto postDto) {
        // 把payload转换成entity，这样才能dao去把该数据存到数据库中。
        /*Post post = new Post();
        if (postDto.getTitle() != null) {
            post.setTitle(postDto.getTitle());
        } else {
            post.setTitle("");
        }
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());*/
        // 此时已成功把request body的信息传递给entity

        //convert DTO to Entity
        Post post = mapToEntity(postDto);

        // 调用Dao的save 方法，将entity的数据存储到数据库MySQL
        // save()会返回存储在数据库中的数据
        Post savedPost = postRepository.save(post);

        // 将save() 返回的数据转换成controller/前端 需要的数据，然后return给controller
        /*PostDto postResponse = new PostDto();
        postResponse.setId(savedPost.getId());
        postResponse.setTitle(savedPost.getTitle());
        postResponse.setDescription(savedPost.getDescription());
        postResponse.setContent(savedPost.getContent());*/

        PostDto postResponse = mapToDTO(savedPost);

        return postResponse;
    }

    @Override
    public List<PostDto> getAllPost() { // 此处练习了lambda， stream API
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = posts
                .stream()
                .map(post -> mapToDTO(post))
                .collect(Collectors.toList());
        return postDtos;
    }

    public PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir){

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        //create pageable instance
        PageRequest pageRequest = PageRequest.of(pageNo,pageSize, sort);
        //PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        //PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        Page<Post> pagePosts = postRepository.findAll(pageRequest);

        //get content for page object
        List<Post> posts = pagePosts.getContent();
        List<PostDto> postDtos = posts
                .stream()
                .map(post -> mapToDTO(post))
                .collect(Collectors.toList());

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
    public PostDto getPostById(long id) {

        //Optional<Post> post = postRepository.findById(id);//repository返回的是一个Optional，允许null； 否则为null的话会是个NPE，是个runtime error，程序会终止
        //post.orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));//optional的方法：orElseThrow
            //除了orElseThrow()去throw exception以外，可以用orElse赋以默认值
        //Post post = postRepository.findById(id).get(); //从optional里面把东西取出来

        Post post = postRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        return mapToDTO(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {

        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));//这样连着写就不用再写.get()了，因为it either throws exception or return
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post updatePost = postRepository.save(post);
        return mapToDTO(updatePost);
    }

    @Override
    public void deletePostById(long id) {

        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);

    }


    private PostDto mapToDTO(Post post){ //post == savedPost

        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());

        return postDto;
    }

    private Post mapToEntity(PostDto postDto){

        Post post = new Post();
        /*if (postDto.getTitle() != null) {
            post.setTitle(postDto.getTitle());
        } else {
            post.setTitle("");
        }*/
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        return post;

    }

    @Override
    public PostResponse searchPostByContentContains(String content) {

        List<Post> posts = postRepository.searchPostsByContentContains(content);//leverage the JPA method provided by Java Spring
        List<PostDto> postDtos = posts
                .stream()
                .map(post -> mapToDTO(post))
                .collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);

        return postResponse;
    }

}
