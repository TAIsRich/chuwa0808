package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostJPQLRepository extends JpaRepository<Post, Long> {
    Post findPostByTitle(String title);
    List<Post> findPostByIdGreaterThan(long id);

    List<Post> getAllPostWithJPQL();

}
