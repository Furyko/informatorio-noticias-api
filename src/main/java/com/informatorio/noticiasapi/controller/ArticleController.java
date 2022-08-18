package com.informatorio.noticiasapi.controller;

import javax.validation.Valid;
import com.informatorio.noticiasapi.entity.Article;
import com.informatorio.noticiasapi.repository.ArticleRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path = "/articles")
public class ArticleController {
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping
    public @ResponseBody Iterable<Article> getArticles() {
        return articleRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createArticle(@Valid @RequestBody Article article)  {
        return new ResponseEntity<>(articleRepository.save(article), HttpStatus.CREATED);
    }
}