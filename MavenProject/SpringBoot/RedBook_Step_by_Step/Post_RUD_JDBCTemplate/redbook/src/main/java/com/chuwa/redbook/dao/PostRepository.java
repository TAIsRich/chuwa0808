package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// PostRepository不再extend JpaRepository<Post, Long>, 即application.properties or application.yml的配置不再起作用，直接自己手写JDBC
// 同时comment dependency in pom.xml: <!--
//		                             <dependency>
//			                             <groupId>org.springframework.boot</groupId>
//			                             <artifactId>spring-boot-devtools</artifactId>
//			                             <scope>runtime</scope>
//			                             <optional>true</optional>
//		                             </dependency>
//		                             -->

// 这里写不写@Repository都可，反正PostRepositoryImpl那里写了@Repository or @Component
@Repository
public interface PostRepository {
    List<Post> findAll();
    Post save(Post post);
    Optional<Post> findById(Long id);
    void delete(Post post);
}
