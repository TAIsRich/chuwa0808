package com.chuwa.redbook.EntityManager.Dao;

import com.chuwa.redbook.EntityManager.Entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostJPQLRepository {

    List<Post> getAllPostWithJPQL();
}