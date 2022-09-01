package com.chuwa.redbook.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.BlogAPIException;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.CommentDto;
import com.chuwa.redbook.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
    
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public CommentDto createCommentDto(Long postId ,CommentDto commentDto){

        Comment comment = mapToEntity(commentDto);

        //find post
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        //set post
        comment.setPost(post);
        //save post to db
        Comment savedComment = commentRepository.save(comment);

        return mapToDto(savedComment);
    }

    @Override
    public List<CommentDto> getCommentByPostId(Long postId){
        // retrieve comments by postId
        List<Comment> comments = commentRepository.findByPostId(postId);
        // convert list of comment entities to list of comment dto's
        return comments.stream().map(comment -> mapToDto(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(Long postId, Long commentId){
       // retrieve post entity by id
       Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
       // retrieve comment by id
       Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));
       // 业务逻辑
       if(!comment.getPost().getId().equals(post.getId())){
          throw new BlogAPIException(HttpStatus.BAD_REQUEST, "comment doee not belong to post");
       }

       return mapToDto(comment);
    }

    @Override
    public CommentDto updatComment(Long postId, Long commentId, CommentDto commentDtoRequest){
      // retrieve post entity by id
      Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
      // retrieve comment by id
      Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));
      // 业务逻辑
      if(!comment.getPost().getId().equals(post.getId())){
         throw new BlogAPIException(HttpStatus.BAD_REQUEST, "comment doee not belong to post");
      }

      comment.setName(commentDtoRequest.getName());
      comment.setBody(commentDtoRequest.getBody());
      comment.setEmail(commentDtoRequest.getEmail());

      Comment updatComment = commentRepository.save(comment);

      return mapToDto(updatComment);
    }

    @Override
    public void deleteComment(Long postId, Long commentId){
       // retrieve post entity by id
       Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
       // retrieve comment by id
       Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));
       // 业务逻辑
       if(!comment.getPost().getId().equals(post.getId())){
          throw new BlogAPIException(HttpStatus.BAD_REQUEST, "comment doee not belong to post");
       }

       commentRepository.delete(comment);
    }


    private CommentDto mapToDto(Comment comment){

        CommentDto commentDto = new CommentDto();

        commentDto.setId(comment.getId());
        commentDto.setBody(comment.getBody());
        commentDto.setEmail(comment.getEmail());
        commentDto.setName(comment.getName());

        return commentDto;

    }

    private Comment mapToEntity(CommentDto commentDto){

        Comment comment = new Comment();

        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());

        return comment;
    }
}
