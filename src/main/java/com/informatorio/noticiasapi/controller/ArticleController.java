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

    private final ArticleRepository articleController;

    @Autowired
    public ArticleController(ArticleRepository articleController) {
        this.articleController = articleController;
    }

    @GetMapping
    public @ResponseBody Iterable<Article> getArticles() {
        return articleController.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createArticle(@Valid @RequestBody Article article)  {
        return new ResponseEntity<>(articleController.save(article), HttpStatus.CREATED);
    }
}