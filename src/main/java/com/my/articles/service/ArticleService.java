package com.my.articles.service;

import com.my.articles.dao.ArticleDao;
import com.my.articles.dto.ArticleDto;
import com.my.articles.entity.Article;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleDao articleDao;

    public ArticleDto findById(Long id) {
        Article article = articleDao.findById(id);
        return new ArticleDto(article.getId(), article.getTitle(), article.getContent());

    }

    public List<Article> findAll() {
        return articleDao.findAll();
    }
}
