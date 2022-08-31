package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepositoryJdbc {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PostRepositoryJdbc() {};

    public List<Post> findAll(){
        String sql = "SELECT * FROM posts";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Post.class));
    }

    public Optional<Post> findById(long id){
        String sql = "SELECT * FROM POSTS WHERE ID = ?";
        Post p = jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<Post>(Post.class),
                id);
        return Optional.ofNullable(p);
    }

    public Post save(Post post){
        final String sql = "INSERT INTO POSTS (" +
                "title, description, content, create_date_time, update_date_time) " +
                "VALUES (?, ?, ?, ?, ?)";
        final KeyHolder keyHolder = new GeneratedKeyHolder();

        int result = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, post.getTitle());
            ps.setString(2, post.getDescription());
            ps.setString(3, post.getContent());
            ps.setObject(4, LocalDateTime.now());
            ps.setObject(5, LocalDateTime.now());
            return ps;
        }, keyHolder);

        if (result > 0) return findById(keyHolder.getKey().longValue()).get();
        return null;
    }

    public Post update(Post post){
        final String sql = "UPDATE POSTS " +
                "SET title = ?, description = ?, content = ? , update_date_time = ? " +
                "WHERE ID = ?";
        jdbcTemplate.update(sql, post.getTitle(),
                post.getDescription(),
                post.getContent(),
                LocalDateTime.now(),
                post.getId());

        return post;
    }

    public void delete(Post post){
        String sql="DELETE FROM POSTS WHERE ID = ?";
        jdbcTemplate.update(sql, post.getId());
    }
}
