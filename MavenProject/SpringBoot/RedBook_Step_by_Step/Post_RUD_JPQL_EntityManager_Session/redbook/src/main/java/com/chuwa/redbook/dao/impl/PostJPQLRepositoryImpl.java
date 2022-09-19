package com.chuwa.redbook.dao.impl;

import com.chuwa.redbook.dao.PostJPQLRepository;
import com.chuwa.redbook.entity.Post;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

// @Repository
@Component("PostJPQLRepositoryImpl")
@Transactional
public class PostJPQLRepositoryImpl implements PostJPQLRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Post> getAllPostsWithJPQL() {
        TypedQuery<Post> posts = entityManager.createNamedQuery("Post.getAll", Post.class);
        return posts.getResultList();
    }

    /**
     * entityManager:
     *  1. Insert, Update: entityManager.merge()
     *  2. Select: entityManager.find();
     *  3. delete: entityManager.remove();
     *
     *  代码的测试在test package下
     */
    public Post insertPost(Post post) {
        // the post could be non-id, 即post中可以没有id
        return entityManager.merge(post);
    }

    public Post updatePost(Post post) {
        // the post has included an id, 即post中必须有id才行
        return entityManager.merge(post);
    }

    public Post getPostById(Long id) {
        return entityManager.find(Post.class, id);
    }

    public void deleteById(Long id) {
        Post post = entityManager.find(Post.class, id);
        entityManager.remove(post);
    }

    public void deleteByTitle(String title) {
        // 这个query does not appear in PostRepository interface as an abstract method, 所以这里需要自己写entityManager.createQuery("SELECT p FROM Post p WHERE p.title = :title", Post.class)
        List<Post> posts = entityManager.createQuery("SELECT p FROM Post p WHERE p.title = :title", Post.class)
                .setParameter("title", title).getResultList();

        if (!posts.isEmpty()) {
            for (Post post: posts) {
                entityManager.remove(post);
            }
        }
    }

    /**
     * practice the generic
     * @param t
     * @param <T>
     */
    public <T> T insertData(T t){
        return entityManager.merge(t);
    }
}
