package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostJPQLRepository {

    List<Post> getAllPostWithJPQL();
}
