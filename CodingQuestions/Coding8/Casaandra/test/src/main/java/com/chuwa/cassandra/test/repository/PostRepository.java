package com.chuwa.cassandra.test.repository;

import com.chuwa.cassandra.test.entity.Post;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableCassandraRepositories
public interface PostRepository extends CrudRepository<Post,Integer> {

}
