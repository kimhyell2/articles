package com.my.articles.dao;

import com.my.articles.entity.Article;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ArticleDao {
    @Autowired
    EntityManager em;

    public List<Article> findAll() {
        String query = "SELECT a FROM Article a";
        return em.createQuery(query, Article.class).getResultList();
    }
}
