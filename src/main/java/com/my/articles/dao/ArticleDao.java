package com.my.articles.dao;

import com.my.articles.dto.ArticleDto;
import com.my.articles.dto.CommentDto;
import com.my.articles.entity.Article;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Component
// 안붙여도 실행은 되지만, 붙여줘야 알아서 일을 잘함 dao에 붙여주자.
@Slf4j
@Transactional
public class ArticleDao {
    @Autowired
    EntityManager em;

//    public List<CommentDto> findAll() {
//        List<CommentDto> commentDtos = new ArrayList<>();
//        String sql = "SELECT a FROM Article a " + "ORDER BY a.id DESC";
//        List<Article> articles = em.createQuery(sql).getResultList();
//
//        for (Article a : articles) {
//            CommentDto dto = new CommentDto();
//
//            if (!ObjectUtils.isEmpty(a.getComments())) {
////                dto.setArticle_id(a.getId());
//                dto.setId(a.getComments());
//                commentDtos.add(dto);
//            }
//        }
//        System.out.println(commentDtos);
//        return null;
//    }

    public List<Article> findAll() {
        String sql = "SELECT a FROM Article a " +
                "ORDER BY a.id DESC";
        List<Article> articles = em.createQuery(sql).getResultList();
        return articles;
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
