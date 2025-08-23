package com.mertcekuc.bloggingPlatform.controller;

import com.mertcekuc.bloggingPlatform.entity.Article;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mertcekuc.bloggingPlatform.service.ArticleService;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class RController {
    private final ArticleService articleService;

    @Autowired
    public RController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public List<Article> getAllArticles() {
        List<Article> articles = articleService.getAllArticles();
        if (articles.isEmpty()) {
            throw new RuntimeException("No articles found");
        }
        return articles;
    }

    @GetMapping("/{slug}")
    public Article getArticleBySlug(@PathVariable String slug) {

        Article article = articleService.getArticleBySlug(slug);
        if (article == null) {
            throw new RuntimeException("Article not found with slug: " + slug);
        }
        return article;
    }

    @PostMapping("/")
    public Article createArticle(@RequestBody Article article) {
        articleService.createArticle(article);
        return article;
    }

    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable String id, @RequestBody Article article) {
        return articleService.updateArticle(id, article);
    }

    @GetMapping("/authors")
    public List<Article> getArticlesByAuthor(@RequestHeader("Author") String author) {
        List<Article> articles = articleService.getArticlesByAuthor(author);
        if (articles.isEmpty()) {
            throw new RuntimeException("No articles found for author: " + author);
        }
        return articles;
    }
    @DeleteMapping("/{id}")
    public Article deleteArticleById(@PathVariable String id) {
        Article article = articleService.getArticleById(id);
        if (article == null) {
            throw new RuntimeException("Article not found with id: " + id);
        }
        articleService.deleteArticleById(id);

        return article;

    }


}
