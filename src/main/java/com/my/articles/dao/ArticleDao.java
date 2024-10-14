package com.my.articles.dao;

import com.my.articles.entity.Article;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
@Slf4j
public class ArticleDao {
    @Autowired
    EntityManager em;

    public List<Article> findAll() {
        String query = "SELECT a FROM Article a";
        return em.createQuery(query, Article.class).getResultList();
    }

    public Article findById(Long id) {
        Article article = em.find(Article.class, id);
        if (article == null) {
            log.error("없다이야 " + id);
        } else {
            log.info("찾았어어: " + article.toString());
        }
        return article;
    }
}
