package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByPostId(long PostId);
}
