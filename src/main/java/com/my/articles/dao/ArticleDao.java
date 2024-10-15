package com.my.articles.dao;

import com.my.articles.dto.ArticleDto;
import com.my.articles.entity.Article;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
// 안붙여도 실행은 되지만, 붙여줘야 알아서 일을 잘함 dao에 붙여주자.
@Slf4j
@Transactional
public class ArticleDao {
    @Autowired
    EntityManager em;

    public List<Article> findAll() {
        String query = "SELECT a FROM Article a ORDER BY a.id DESC";
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

    public void deleteArticle(Long id) {
        Article article = em.find(Article.class, id);
        em.remove(article);
    }

    public void updateArticle(ArticleDto dto) {
        Article article = em.find(Article.class, dto.getId());
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
    }

    public void insertArticle(Article article) {
        em.persist(article);
    }
}
