package com.chuwa.redbook.dao.impl;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepositoryImpl implements PostRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PostRepositoryImpl() {
    }

    @Override
    public List<Post> findAll() {
        final String sql = "SELECT * FROM posts";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Post.class));
    }

    @Override
    public Post save(Post post) {
        final String sql = "INSERT INTO posts(title, description, content, create_date_time, update_date_time)" +
                "VALUES(?, ?, ?, ?, ?)";
        final KeyHolder keyHolder = new GeneratedKeyHolder();
        int result = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, post.getTitle());
            ps.setString(2, post.getDescription());
            ps.setString(3, post.getContent());
            ps.setObject(4, LocalDateTime.now());
            ps.setObject(5,LocalDateTime.now());
            return ps;
        }, keyHolder);

        if (post.getId() == null) {
            return result > 0 ? findById(keyHolder.getKey().longValue()).get() : null;
        } else {
            return result > 0 ? findById(post.getId()).get() : null;
        }
    }

    @Override
    public Optional<Post> findById(Long id) {
        final String sql = "SELECT * FROM posts WHERE id = ?";
        Post p = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Post.class), new Object[]{id});
        return Optional.ofNullable(p);
    }

    @Override
    public void delete(Post post) {
        final String sql = "DELETE FROM POSTS WHERE id = ?";
        jdbcTemplate.update(sql, new Object[]{post.getId()});
    }
}
