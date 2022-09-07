package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.DAO.CommentRepository;
import com.chuwa.redbook.DAO.PostRepository;
import com.chuwa.redbook.service.CommentService;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.BlogAPIException;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.CommentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        //Comment comment = mapToEntity(commentDto);
        Comment comment = modelMapper.map(commentDto, Comment.class);
//         retrieve post entity by id
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
//         set post to comment entity
        comment.setPost(post);

//         comment entity to DB
        Comment savedComment = commentRepository.save(comment);

        //return mapToDto(savedComment);
        return modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public List<CommentDto> getCommentsByPostId(long postId) {
//         retrieve comments by postId
        List<Comment> comments = commentRepository.findByPostId(postId);

//         convert list of comment entities to list of comment dto's
        //return comments.stream().map(comment -> mapToDto(comment)).collect(Collectors.toList());
        return comments.stream().map(comment -> modelMapper.map(comment, CommentDto.class)).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(Long postId, Long commentId) {
//         retrieve post entity by id
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

//         retrieve comment by id
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

//         业务逻辑
        if (!comment.getPost().getId().equals(post.getId())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }

        //return mapToDto(comment);
        return modelMapper.map(comment, CommentDto.class);
    }

    @Override
    public CommentDto updateComment(Long postId, Long commentId, CommentDto commentDtoRequest) {
//         retrieve post entity by id
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

//         retrieve comment by id
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

//         业务逻辑
        if (!comment.getPost().getId().equals(post.getId())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }

        comment.setName(commentDtoRequest.getName());
        comment.setEmail(commentDtoRequest.getEmail());
        comment.setBody(commentDtoRequest.getBody());

        Comment updatedComment = commentRepository.save(comment);

        //return mapToDto(updatedComment);
        return modelMapper.map(updatedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Long postId, Long commentId) {
//         retrieve post entity by id
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

//         retrieve comment by id
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        if (!comment.getPost().getId().equals(post.getId())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }

        commentRepository.delete(comment);
    }

//    private CommentDto mapToDto(Comment comment) {
//        CommentDto commentDto = new CommentDto();
//        commentDto.setId(comment.getId());
//        commentDto.setName(comment.getName());
//        commentDto.setEmail(comment.getEmail());
//        commentDto.setBody(comment.getBody());
//
//        return commentDto;
//    }
//
//    private Comment mapToEntity(CommentDto commentDto) {
//        Comment comment = new Comment();
//        comment.setId(commentDto.getId());
//        comment.setName(commentDto.getName());
//        comment.setEmail(commentDto.getEmail());
//        comment.setBody(commentDto.getBody());
//
//        return comment;
//    }
}
