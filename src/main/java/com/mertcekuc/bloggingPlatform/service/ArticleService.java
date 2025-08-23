package com.mertcekuc.bloggingPlatform.service;

import com.mertcekuc.bloggingPlatform.entity.Article;

import java.util.List;

public interface ArticleService {

    void createArticle(Article article);

    Article getArticleBySlug(String slug);

    List<Article> getAllArticles();

    Article updateArticle(String id, Article article);

    void deleteArticleBySlug(String slug);

    void deleteArticleById(String id);

    Article getArticleById(String id);

    List<Article> getArticlesByAuthor(String author);
}
