package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    //JPQL by using Entity name instead of database table name
    //index parameters
    @Query("select p from Post p where p.id = ?1 or p.title = ?2")
    Post getPostByIdOrTitleWithJPQLIndexParameter(Long id, String title);


    //JPQL by using Entity name instead of database table name
    //the parameter name has a ":" ahead inside the @Query
    //index parameters
    @Query("select p from Post p where p.id = :key or p.title = :title")
    Post getPostByIdOrTitleWithJPQLNamedParameter(@Param("key") Long id,
                                                  @Param("title") String title);

    //SQL by using database table name
    //index parameter
    @Query(value = "select * from posts p where p.id = ?1 or p.title =?2", nativeQuery = true)
    Post getPostByIDOrTitleWithSQLIndexParameters(Long id, String title);


    //SQL by using Entity name instead of database table name
    // named parameter
    @Query(value = "select * from posts p where p.id = :key or p.title = :title", nativeQuery = true)
    Post getPostByIdOrTitleWithSQLNamedParameters(@Param("key") Long id,
                                                  @Param("title") String title);
}
