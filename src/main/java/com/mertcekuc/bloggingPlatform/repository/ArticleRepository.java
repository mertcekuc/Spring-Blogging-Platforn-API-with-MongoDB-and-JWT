package com.mertcekuc.bloggingPlatform.repository;

import com.mertcekuc.bloggingPlatform.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ArticleRepository {

    void createArticle(Article article);
    Article findBySlug(String slug);
    List<Article> findAllArticles();
    void updateArticle(Article article);
    void deleteArticleBySlug(String slug);
    void deleteArticleById(String id);
    Article findById(String id);
    List<Article> findByAuthor(String author);

}
