package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Post findPostByTitle(String title);
    List<Post> findPostByIdGreaterThan(long id);
}
