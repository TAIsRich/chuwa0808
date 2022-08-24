package com.chuwa.mongoblog.dao;

import com.chuwa.mongoblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
