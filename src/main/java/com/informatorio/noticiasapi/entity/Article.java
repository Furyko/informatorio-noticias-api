package com.informatorio.noticiasapi.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import javax.validation.constraints.NotEmpty;
import com.informatorio.noticiasapi.entity.Author;
import com.informatorio.noticiasapi.entity.Source;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El titulo no puede estar vacio.")
    private String title;

    @NotEmpty(message = "La descripción no puede estar vacia.")
    private String description;

    @NotEmpty(message = "La url no puede estar vacia.")
    private String url;

    @NotEmpty(message = "La imagen no puede estar vacia.")
    private String urlToImage;

    @CreationTimestamp
    private LocalDateTime publishedAt;

    @NotEmpty(message = "El contenido no puede estar vacio.")
    private String content;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Author author;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Source source;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    } 

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}