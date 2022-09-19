package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // no need to write code:
    // 在Spring frame中，the methods like findAll()是interface JpaRepository<T, ID> which is extended by our interface PostRepository自有的abstract method
    // 由Hibernate实现，our PostRepository object可以直接调用
}
