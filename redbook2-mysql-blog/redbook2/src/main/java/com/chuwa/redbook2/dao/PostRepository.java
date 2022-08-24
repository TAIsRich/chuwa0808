package com.chuwa.redbook2.dao;

import com.chuwa.redbook2.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    //no need to write code
}
