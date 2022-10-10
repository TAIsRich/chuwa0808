package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.PostResponse;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PostServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(PostServiceImplTest.class);

    @Mock
    private PostRepository postRepository;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private PostServiceImpl postService;

    private PostDto postDto;
    private Post post;

    @BeforeAll
    static void beforeAll(){
        logger.info("Start testing");
    }

    @BeforeEach
    void setUp() {
        logger.info("set up Post for each test");

        this.post = new Post(1L, "Shopping Haul", "shopping", "Shopping haul in Sep",
                LocalDateTime.now(), LocalDateTime.now());
        ModelMapper modelMapper = new ModelMapper();
        this.postDto = modelMapper.map(this.post, PostDto.class);
    }

    @Test
    public void testCreatePost(){
        // define the behavior
        Mockito.when(postRepository.save(ArgumentMatchers.any(Post.class)))
                .thenReturn(post);
        // execute
        PostDto postResponse = postService.createPst(postDto);

        // assertions
        Assertions.assertNotNull(postResponse);
        Assertions.assertEquals(post.getId(), postResponse.getId());
        Assertions.assertEquals(post.getTitle(), postResponse.getTitle());
        Assertions.assertEquals(post.getDescription(), postResponse.getDescription());
        Assertions.assertEquals(post.getContent(), postResponse.getContent());
    }

    @Test
    public void testGetAllPost(){
        List<Post> posts = new ArrayList<>();
        posts.add(post);

        //define behavior
        Mockito.when(postRepository.findAll())
                .thenReturn(posts);

        //execute
        List<PostDto> postDtos = postService.getAllPosts();

        //assertions
        Assertions.assertNotNull(postDtos);
        Assertions.assertEquals(1, postDtos.size());
        PostDto postDto1 = postDtos.get(0);
        Assertions.assertEquals(post.getId(), postDto1.getId());
        Assertions.assertEquals(post.getTitle(), postDto1.getTitle());
        Assertions.assertEquals(post.getContent(), postDto1.getContent());
        Assertions.assertEquals(post.getDescription(), postDto1.getDescription());
    }

    @Test
    public void testGetPostById(){
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));

        PostDto postResponse = postService.getPostById(1L);

        Assertions.assertNotNull(postResponse);
        Assertions.assertEquals(postDto.getTitle(), postResponse.getTitle());
        Assertions.assertEquals(postDto.getDescription(), postResponse.getDescription());
        Assertions.assertEquals(postDto.getContent(), postResponse.getContent());
    }

    @Test
    public void testGetPostById_ResourceNotFound(){
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("post", "id", 1L));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> postService.getPostById(1l));
    }

    @Test
    public void testUpdatePost(){
        String description = "UPDATED - " + post.getDescription();
        postDto.setDescription(description);

        Post updatedPost = new Post();
        updatedPost.setId(post.getId());
        updatedPost.setTitle(post.getTitle());
        updatedPost.setDescription(description);
        updatedPost.setContent(post.getContent());

        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));

        Mockito.when(postRepository.save(ArgumentMatchers.any(Post.class)))
                .thenReturn(updatedPost);

        PostDto postResponse = postService.updatPost(postDto, 1l);

        Assertions.assertNotNull(postResponse);
        Assertions.assertEquals(postDto.getDescription(), postResponse.getDescription());
        Assertions.assertEquals(postDto.getTitle(), postResponse.getTitle());
        Assertions.assertEquals(postDto.getContent(), postResponse.getContent());
    }

    @Test
    public void testUpdatePost_NoResourceFound(){
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1l));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> postService.getPostById(1l));
    }

    @Test
    public void testDeletePostById(){
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(post));

        Mockito.doNothing().when(postRepository).delete(ArgumentMatchers.any(Post.class));

        postService.deletePostById(1l);

        Mockito.verify(postRepository, Mockito.times(1)).delete(ArgumentMatchers.any(Post.class));
    }

    @Test
    public void testDeletePostById_NoResourceFound(){
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1l));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> postService.deletePostById(1l));
    }

    @Test
    public void testGetAllPosts_Pageable(){
        int pageNo = 1;
        int pageSize = 8;
        String sortBy = "title";
        String sortDir = Sort.Direction.ASC.name();
        Long totalElements = 22L;
        int totalPages = (int) Math.ceil(totalElements/pageSize);
        boolean isLast = pageNo == totalPages;

        List<Post> posts = new ArrayList<>();
        posts.add(post);

        Page<Post> pagePosts = Mockito.mock(Page.class);
        Mockito.when(pagePosts.getContent()).thenReturn(posts);
        Mockito.when(pagePosts.getNumber()).thenReturn(pageNo);
        Mockito.when(pagePosts.getSize()).thenReturn(pageSize);
        Mockito.when(pagePosts.getTotalElements()).thenReturn(totalElements);
        Mockito.when(pagePosts.getTotalPages()).thenReturn(totalPages);
        Mockito.when(pagePosts.isLast()).thenReturn(isLast);

        Mockito.when(postRepository.findAll(ArgumentMatchers.any(PageRequest.class)))
                .thenReturn(pagePosts);

        PostResponse postResponse = postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);

        Assertions.assertNotNull(postResponse);
        Assertions.assertEquals(postResponse.getPageNo(), pageNo);
        Assertions.assertEquals(postResponse.getPageSize(), pageSize);
        Assertions.assertEquals(postResponse.getTotalElements(), totalElements);
        Assertions.assertEquals(postResponse.getTotalPages(), totalPages);
        Assertions.assertEquals(postResponse.isLast(), isLast);

        List<PostDto> postDtos = postResponse.getContent();
        Assertions.assertNotNull(postDtos);
        Assertions.assertEquals(postDtos.size(), posts.size());
        PostDto postDto1 = postDtos.get(0);
        Assertions.assertEquals(postDto1.getTitle(), postDto.getTitle());
        Assertions.assertEquals(postDto1.getDescription(), postDto.getDescription());
        Assertions.assertEquals(postDto1.getContent(), postDto.getContent());
    }

    @Test
    public void testGetAllPosts_Pageable_Descending(){
        int pageNo = 1;
        int pageSize = 8;
        String sortBy = "title";
        String sortDir = Sort.Direction.DESC.name();
        Long totalElements = 22L;
        int totalPages = (int) Math.ceil(totalElements/pageSize);
        boolean isLast = pageNo == totalPages;

        List<Post> posts = new ArrayList<>();
        posts.add(post);

        Page<Post> pagePosts = Mockito.mock(Page.class);
        Mockito.when(pagePosts.getContent()).thenReturn(posts);
        Mockito.when(pagePosts.getNumber()).thenReturn(pageNo);
        Mockito.when(pagePosts.getSize()).thenReturn(pageSize);
        Mockito.when(pagePosts.getTotalElements()).thenReturn(totalElements);
        Mockito.when(pagePosts.getTotalPages()).thenReturn(totalPages);
        Mockito.when(pagePosts.isLast()).thenReturn(isLast);

        Mockito.when(postRepository.findAll(ArgumentMatchers.any(PageRequest.class)))
                .thenReturn(pagePosts);

        PostResponse postResponse = postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);

        Assertions.assertNotNull(postResponse);
        Assertions.assertEquals(postResponse.getPageNo(), pageNo);
        Assertions.assertEquals(postResponse.getPageSize(), pageSize);
        Assertions.assertEquals(postResponse.getTotalElements(), totalElements);
        Assertions.assertEquals(postResponse.getTotalPages(), totalPages);
        Assertions.assertEquals(postResponse.isLast(), isLast);

        List<PostDto> postDtos = postResponse.getContent();
        Assertions.assertNotNull(postDtos);
        Assertions.assertEquals(postDtos.size(), posts.size());
        PostDto postDto1 = postDtos.get(0);
        Assertions.assertEquals(postDto1.getTitle(), postDto.getTitle());
        Assertions.assertEquals(postDto1.getDescription(), postDto.getDescription());
        Assertions.assertEquals(postDto1.getContent(), postDto.getContent());
    }

    @AfterAll
    static void afterAll(){
        logger.info("End testing");
    }
}
