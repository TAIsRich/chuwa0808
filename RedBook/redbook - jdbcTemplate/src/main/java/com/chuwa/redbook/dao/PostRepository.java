package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.PostDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.security.Timestamp;
import java.util.List;

@Repository
public class PostRepository {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();
    public List<Post> findAll(){
        String sql = "SELECT * FROM POSTS";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Post>(Post.class));
    }

    public Post findById(long id){
        String sql = "SELECT * FROM POSTS WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql,
                                new BeanPropertyRowMapper<Post>(Post.class),
                                new Object[] {id});
    }

    public void post(PostDto postDto){
        String sql = "INSERT INTO POSTS (title, description, content) " + "VALUES (?, ?, ?)";

        jdbcTemplate.update( sql, postDto.getTitle(), postDto.getDescription(), postDto.getContent());
    }

    public void update(PostDto postDto, long id){
        String sql = "UPDATE POSTS " + "SET title = ?, description = ?, content = ?" + "WHERE id = ?";

        jdbcTemplate.update( sql, postDto.getTitle(), postDto.getDescription(), postDto.getContent(), id);
    }

    public void delete(long id){
        String sql="DELETE FROM POSTS WHERE ID = ?";
        jdbcTemplate.update(sql, new Object[] {id});
    }
}
