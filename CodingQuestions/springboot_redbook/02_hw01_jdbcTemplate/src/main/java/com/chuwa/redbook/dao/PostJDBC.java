package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.Post;

import java.sql.*;

public class PostJDBC {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL =
            "jdbc:mysql://localhost:3306/redbook";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
//    findAll
//    findById
//            save
//            delete

    public Post findById(long id) throws Exception {
        Post post = new Post();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
// 1, load Driver
            Class.forName(DRIVER);
// 2， connect to Database;
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
// 3， define sql statement
            String sql = "SELECT * FROM redbook WHERE ID = " + id; // 4, create a statement object
            stmt = conn.createStatement();
// 5, use stmt object to execute sql statement;
            rs = stmt.executeQuery(sql); // the result is return
            while(rs.next()) {
                // 6, get ResultSet's data to java object(employee)
                post.setId(rs.getLong("id"));
                post.setTitle(rs.getString("title"));
                post.setDescription(rs.getString("description"));
                post.setContent(rs.getString("content"));
            }
// 7, close conections and other resource.
            rs.close();
            stmt.close();
            conn.close();
            return post;
        } catch (SQLException e) {
        }
        return null;
    }

    public Post findAll() throws Exception {
        Post post = new Post();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
// 1, load Driver
            Class.forName(DRIVER);
// 2， connect to Database;
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
// 3， define sql statement
            String sql = "SELECT * FROM redbook"; // 4, create a statement object
            stmt = conn.createStatement();
// 5, use stmt object to execute sql statement;
            rs = stmt.executeQuery(sql); // the result is return
            while(rs.next()) {
                // 6, get ResultSet's data to java object
                post.setId(rs.getLong("id"));
                post.setTitle(rs.getString("title"));
                post.setDescription(rs.getString("description"));
                post.setContent(rs.getString("content"));
            }
// 7, close conections and other resource.
            rs.close();
            stmt.close();
            conn.close();
            return post;
        } catch (SQLException e) {
        }
        return null;
    }

    public Post save(Post posts) throws Exception {
        Post post = new Post();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
// 1, load Driver
            Class.forName(DRIVER);
// 2， connect to Database;
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
// 3， define sql statement
            String sql = "INSERT INTO redbook (id, title, description, content) VALUES (id, title, description, content)"; // 4, create a statement object
            stmt = conn.createStatement();
// 5, use stmt object to execute sql statement;
            rs = stmt.executeQuery(sql); // the result is return
            while(rs.next()) {
                // 6, get ResultSet's data to java object
                rs.updateLong("id", post.getId());
                rs.updateString("title", post.getTitle());
                rs.updateString("description", post.getDescription());
                rs.updateString("content", post.getContent());
            }
// 7, close conections and other resource.
            rs.close();
            stmt.close();
            conn.close();
            return post;
        } catch (SQLException e) {
        }
        return null;
    }

    public Post delete(Post posts) throws Exception {
        Post post = new Post();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
// 1, load Driver
            Class.forName(DRIVER);
// 2， connect to Database;
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
// 3， define sql statement
            String sql = "DELETE * FROM redbook WHERE ID = " + post.getId(); // 4, create a statement object
            stmt = conn.createStatement();
// 5, use stmt object to execute sql statement;
            rs = stmt.executeQuery(sql); // the result is return
            rs.deleteRow();
// 7, close conections and other resource.
            rs.close();
            stmt.close();
            conn.close();
            return post;
        } catch (SQLException e) {
        }
        return null;
    }
}

