package com.mertcekuc.bloggingPlatform.repository;

import com.mertcekuc.bloggingPlatform.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository{
    public final MongoTemplate mongoTemplate;

    @Autowired
    public ArticleRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void createArticle(Article article) {
        mongoTemplate.insert(article, "articles");
    }

    @Override
    public Article findBySlug(String slug) {
        return mongoTemplate.findOne(
                Query.query(Criteria.where("slug").is(slug)), Article.class
        );
    }

    @Override
    public List<Article> findAllArticles() {
        return mongoTemplate.findAll(Article.class, "articles");
    }

    @Override
    public void updateArticle(Article article) {
        mongoTemplate.save(article, "articles");
    }


    @Override
    public void deleteArticleById(String id) {
        mongoTemplate.remove(Query.query(Criteria.where("_id").is(id)), Article.class, "articles");
    }

    @Override
    public Article findById(String id) {
        return mongoTemplate.findById(id, Article.class, "articles");
    }

    @Override
    public List<Article> findByAuthor(String author) {
        return mongoTemplate.find(
                Query.query((Criteria.where("author").is(author))), Article.class, "articles"
        );
    }
}
