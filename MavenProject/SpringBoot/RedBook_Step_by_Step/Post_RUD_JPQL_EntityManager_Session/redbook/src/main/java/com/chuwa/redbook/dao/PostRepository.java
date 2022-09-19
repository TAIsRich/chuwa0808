package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// PostRepository要extend JpaRepository<Post, Long>, 因为要在PostServiceImpl中的createPost()中用save方法：Post savedPost = postRepository.save(post)
// 同时comment dependency in pom.xml: <!--
//		                             <dependency>
//			                             <groupId>org.springframework.boot</groupId>
//			                             <artifactId>spring-boot-devtools</artifactId>
//			                             <scope>runtime</scope>
//			                             <optional>true</optional>
//		                             </dependency>

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    /**
     * JPQL
     * use Entity name instead of  database table name
     * index parameters
     * the parameter name has a "?" ahead inside the @Query
     * @return Post
     */
    @Query("select p from Post p where p.id = ?1 or p.title = ?2")
    Post getPostByIdOrTitleWithJPQLIndexParameters(Long id, String title);

    /**
     * JPQL
     * use Entity name instead of database table name
     * named parameters
     * the parameter name has a ":" ahead inside the @Query
     * @return Post
     */
    @Query("select p from Post p where p.id = :key or p.title = :title")
    Post getPostByIdOrTitleWithJPQLNamedParameters(@Param("key") Long id, @Param("title") String title);

    /**
     * SQL
     * use database table name
     * index parameters
     * @return Post
     */
    @Query(value = "select * from posts p where p.id = ?1 or p.title = ?2", nativeQuery = true)
    Post getPostByIDOrTitleWithSQLIndexParameters(Long id, String title);

    /**
     * SQL
     * use database table name
     * named parameters
     * @return Post
     */
    @Query(value = "select * from posts p where p.id = :key or p.title = :title", nativeQuery = true)
    Post getPostByIDOrTitleWithSQLNamedParameters(@Param("key") Long id, @Param("title") String title);
}
