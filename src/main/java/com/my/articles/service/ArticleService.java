package com.my.articles.service;

import com.my.articles.dao.ArticleDao;
import com.my.articles.dto.ArticleDto;
import com.my.articles.dto.CommentDto;
import com.my.articles.entity.Article;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleDao articleDao;

    public ArticleDto findById(Long id) {
        Article article = articleDao.findById(id);

        if(ObjectUtils.isEmpty(article)) return null;
//        System.out.println("=================" + article.getComments());
        return ArticleDto.fromEntity(article);
    }

    public List<ArticleDto> findAll() {
        List<Article> all = articleDao.findAll();
        return all.stream().map(x->ArticleDto.fromEntity(x)).toList();
    }

    public void deleteArticle(Long id) {
        articleDao.deleteArticle(id);
    }

    public void updateArticle(ArticleDto dto) {
        articleDao.updateArticle(dto);
    }

    public void insertArticle(ArticleDto dto) {
        articleDao.insertArticle(ArticleDto.fromDto(dto));
    }
}
