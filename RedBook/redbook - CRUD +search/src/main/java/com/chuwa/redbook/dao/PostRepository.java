package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long > {
    List<Post> searchPostsByTitleContainsOrDescriptionContainsOrContentContains(String title, String description, String content);
}
