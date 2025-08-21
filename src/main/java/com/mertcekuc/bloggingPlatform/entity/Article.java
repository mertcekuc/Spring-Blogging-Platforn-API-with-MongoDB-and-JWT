package com.mertcekuc.bloggingPlatform.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document(collection = "articles")
public class Article {

    @Id
    private String id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime publishDate;
    private LocalDateTime lastModified;

    public Article() {
    }
    public Article(String title, String content, String author, LocalDateTime publishDate, LocalDateTime lastModified) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.publishDate = publishDate;
        this.lastModified = lastModified;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return "article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", publishDate=" + publishDate +
                ", lastModified=" + lastModified +
                '}';
    }
}
