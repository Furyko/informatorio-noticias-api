package com.informatorio.noticiasapi.service;

import java.util.Objects;
import com.informatorio.noticiasapi.entity.Article;
import com.informatorio.noticiasapi.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Iterable<Article> findAll() {
        return articleRepository.findAll();
    }

    public Iterable<Article> findBySearch(String search) {
        return articleRepository.findByTitle(search);
    }

    public Article findById(Long id) {
        return articleRepository.getById(id);
    }

    public Article saveOrUpdate(Article article) {
        return articleRepository.save(article);
    }

    public void deleteArticle(Long id) {
        Article article = articleRepository.getById(id);
        articleRepository.delete(article);
    }
}