package com.my.articles.service;

import com.my.articles.dao.ArticleDao;
import com.my.articles.entity.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleDao dao;

    public List<Article> findAll() {
        return dao.findAll();
    }
}
