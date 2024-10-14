package com.my.articles.dto;

import com.my.articles.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {
    private Long id;
    private String title;
    private String content;

    // E -> D
    public static ArticleDto fromEntity(Article article) {
        return new ArticleDto(
                article.getId(),
                article.getTitle(),
                article.getContent()
        );
    }
}
