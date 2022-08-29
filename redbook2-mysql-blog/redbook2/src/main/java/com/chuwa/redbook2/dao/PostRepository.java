package com.chuwa.redbook2.dao;

import com.chuwa.redbook2.entity.Post;
import com.chuwa.redbook2.payload.PostDto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    //no need to write code

    //public Page<Post> searchPostByContentContains(String content);
    public List<Post> searchPostsByContentContains(String content);

}
