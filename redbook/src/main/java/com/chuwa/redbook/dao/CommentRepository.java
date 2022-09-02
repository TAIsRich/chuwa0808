package com.chuwa.redbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chuwa.redbook.entity.Comment;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

    java.util.List<Comment> findByPostId(Long postId);
    
}
