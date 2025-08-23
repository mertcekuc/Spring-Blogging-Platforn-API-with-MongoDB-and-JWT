package com.mertcekuc.bloggingPlatform.service;

import com.mertcekuc.bloggingPlatform.entity.Article;
import com.mertcekuc.bloggingPlatform.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public void createArticle(Article article) {
        article.setPublishDate(LocalDateTime.now());
        updateSlug(article);
        articleRepository.createArticle(article);
    }

    @Override
    public Article getArticleBySlug(String slug) {
        return articleRepository.findBySlug(slug);
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAllArticles();
    }

    @Override
    public Article updateArticle(String id, Article article) {
        Article existingArticle = articleRepository.findById(id);
        if (existingArticle == null) {
            throw new RuntimeException("Article not found with id: " + id);
        }

        existingArticle.setTitle(article.getTitle());
        existingArticle.setContent(article.getContent());
        existingArticle.setLastModified(LocalDateTime.now());
        updateSlug(existingArticle);
        articleRepository.updateArticle(existingArticle);
        return existingArticle;
    }

    @Override
    public void deleteArticleBySlug(String slug) {
        Article article = articleRepository.findBySlug(slug);
        if (article == null) {
            throw new RuntimeException("Article not found with slug: " + slug);
        }
        articleRepository.deleteArticleById(article.getId());

    }

    @Override
    public void deleteArticleById(String id) {
        Article article = articleRepository.findById(id);
        if (article == null) {
            throw new RuntimeException("Article not found with id: " + id);
        }
        articleRepository.deleteArticleById(id);

    }

    @Override
    public Article getArticleById(String id) {
        return articleRepository.findById(id);
    }

    @Override
    public List<Article> getArticlesByAuthor(String author) {
        return articleRepository.findByAuthor(author);
    }

    public void updateSlug(Article article) {
        String title = article.getTitle();
        String slug = title.toLowerCase()
                .replaceAll("[^a-z0-9]+", "-")
                .replaceAll("(^-|-$)", "");

        article.setSlug(slug);
    }
}
