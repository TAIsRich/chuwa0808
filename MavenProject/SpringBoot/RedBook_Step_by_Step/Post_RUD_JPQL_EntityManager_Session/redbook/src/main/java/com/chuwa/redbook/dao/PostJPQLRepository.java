package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

// 这里不写@Repository可以，反正PostJPQLRepositoryImpl那里写了@Repository or @Component
// 但是这里如果写了@Repository，PostServiceImpl里的@Autowired private PostJPQLRepository postJPQlRepository必须加@Qualifier表明是PostJPQLRepositoryImpl这个bean
@Repository
public interface PostJPQLRepository{
    List<Post> getAllPostsWithJPQL();
}
