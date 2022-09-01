package com.chuwa.redbook.dao.impl;

import com.chuwa.redbook.dao.PostJPQLRepository;
import com.chuwa.redbook.entity.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PostJPQLRepositoryImpl implements PostJPQLRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Post> getAllPostWithJPQL() {
        TypedQuery<Post> posts = entityManager.createNamedQuery("Post.getAll", Post.class);
        return posts.getResultList();
    }

    public Post insertPost(Post post) {
        return entityManager.merge(post);
    }

    public Post updatePost(Post post) {
        return entityManager.merge(post);
    }

    public Post getPostById(long id) {
        return entityManager.find(Post.class, id);
    }

    public void deleteById(long id) {
        Post post = entityManager.find(Post.class, id);
        entityManager.remove(post);
    }

    public void deleteByTitle(String title) {
        List<Post> posts = entityManager.createQuery("SELECT p FROM Post p WHERE p.title = :title", Post.class)
                .setParameter("title", title).getResultList();
        if (!posts.isEmpty()) {
            for (Post post: posts) {
                entityManager.remove(post);
            }
        }
    }

    public <T> T insertData(T t) {
        return entityManager.merge(t);
    }
}
