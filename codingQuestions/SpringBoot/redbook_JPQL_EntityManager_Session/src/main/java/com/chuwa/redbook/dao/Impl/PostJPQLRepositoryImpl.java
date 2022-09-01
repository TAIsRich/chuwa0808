package com.chuwa.redbook.dao.Impl;

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

    /**
     * for the entityManager
     * insert update: entityManager.merge();
     * select: entityManager.find();
     * delete: entityManager.remove();
     */

    public Post insertPost(Post post){
        //there could be non-id for the post
        return entityManager.merge(post);
    }

    public Post updatePost(Post post){
        //the Post has included the id
        return entityManager.merge(post);
    }

    public Post getPostById(Long id){
        return entityManager.find(Post.class, id);
    }

    public void deleteById(Long id){
        Post post = entityManager.find(Post.class, id);
        entityManager.remove(post);
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
