package com.informatorio.noticiasapi.controller;

import javax.validation.Valid;
import com.informatorio.noticiasapi.entity.Article;
import com.informatorio.noticiasapi.service.ArticleService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path = "/api/v1/articles")
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public @ResponseBody Iterable<Article> getArticles() {
        return articleService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createArticle(@Valid @RequestBody Article article) {
        Article newArticle = articleService.saveOrUpdate(article);
        return new ResponseEntity<Article>(newArticle, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public void deleteArticle(@PathVariable("id") Long id) {
        articleService.deleteArticle(id);
    }
}