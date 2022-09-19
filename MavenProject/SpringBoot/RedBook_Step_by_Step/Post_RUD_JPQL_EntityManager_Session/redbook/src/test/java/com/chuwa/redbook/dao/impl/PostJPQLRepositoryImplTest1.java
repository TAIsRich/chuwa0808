package com.chuwa.redbook.dao.impl;

import com.chuwa.redbook.entity.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostJPQLRepositoryImplTest1 {

    private static final String INSERTED_POST_TITLE = "title_test";
    private static final String INSERTED_POST_DESC = "desc_test";
    private static final String INSERTED_POST_CONTENT = "content_test";

    private static final String UPDATED_POST_TITLE = "title_test_update";
    private static final String UPDATED_POST_DESC = "desc_test_update";
    private static final String UPDATED_POST_CONTENT = "content_test_update";

    @Autowired
    private PostJPQLRepositoryImpl repository;

    private Post insertedPost = new Post(null, INSERTED_POST_TITLE, INSERTED_POST_DESC, INSERTED_POST_CONTENT, null, null);
    private Post updatedPost = new Post(null, UPDATED_POST_TITLE, UPDATED_POST_DESC, UPDATED_POST_CONTENT, null, null);
    private Post post = new Post(null, "session_title", "session_des", "session_content",  null, null);

    @BeforeEach
    void cleanUpPost() {
        repository.deleteByTitle(INSERTED_POST_TITLE);
        repository.deleteByTitle(UPDATED_POST_TITLE);
    }

    @Test
    void getAllPostWithJPQL() {
        List<Post> posts = repository.getAllPostsWithJPQL();
        assertFalse(posts.isEmpty());
    }

    @Test
    void insertPost() {
        // insert post and verify inserted post is the same as original post
        Post postInserted = repository.insertPost(insertedPost);
        assertNotNull(postInserted.getId());
        assertEquals(insertedPost.getTitle(), postInserted.getTitle());
        assertEquals(insertedPost.getDescription(), postInserted.getDescription());
        assertEquals(insertedPost.getContent(), postInserted.getContent());

        // make sure insert same post will throw exception
        assertThrowsExactly(DataIntegrityViolationException.class, () -> repository.insertPost(insertedPost));

        // clean up
        repository.deleteById(postInserted.getId());
    }

    @Test
    void updatePost() {
        // insert post and update this post
        Post postInserted = repository.insertPost(insertedPost);
        updatedPost.setId(postInserted.getId());
        repository.updatePost(updatedPost);

        // verify the post update successful
        Post post = repository.getPostById(postInserted.getId());
        assertEquals(post.getId(), updatedPost.getId());
        assertEquals(post.getTitle(), updatedPost.getTitle());
        assertEquals(post.getDescription(), updatedPost.getDescription());
        assertEquals(post.getContent(), updatedPost.getContent());

        // clean up
        repository.deleteById(post.getId());
    }

    @Test
    void getPostById() {
        // insert post and get this post by id
        Post postInserted = repository.insertPost(insertedPost);
        Post post = repository.getPostById(postInserted.getId());

        // verify get the right post by its id
        assertEquals(post.getTitle(), insertedPost.getTitle());
        assertEquals(post.getDescription(), insertedPost.getDescription());
        assertEquals(post.getContent(), insertedPost.getContent());

        // clean up
        repository.deleteById(post.getId());
    }

    @Test
    void deleteById() {
        // insert a post and delete it by its id
        Post postInserted = repository.insertPost(insertedPost);
        repository.deleteById(postInserted.getId());

        // test the post by deleted
        assertNull(repository.getPostById(postInserted.getId()));
    }

    @Test
    void testSessionFactory() {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            post.setTitle(post.getTitle() + LocalDateTime.now());
            post.setCreateDateTime(LocalDateTime.now());
            post.setUpdateDateTime(LocalDateTime.now());
            Post savedPost = (Post)session.merge(post);
            System.out.println(savedPost);

            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }
}
