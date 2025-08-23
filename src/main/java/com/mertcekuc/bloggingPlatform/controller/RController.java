package com.mertcekuc.bloggingPlatform.controller;

import com.mertcekuc.bloggingPlatform.entity.Article;
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
    public Article getArticleBySlug(String slug) {

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


}
