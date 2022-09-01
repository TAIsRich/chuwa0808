package com.chuwa.CassandraBlog.dao;

import com.chuwa.CassandraBlog.entity.Post;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface PostRepository extends CassandraRepository<Post, UUID> {
}
