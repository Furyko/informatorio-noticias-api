package com.informatorio.noticiasapi.controller;

import javax.validation.Valid;
import com.informatorio.noticiasapi.entity.Author;
import com.informatorio.noticiasapi.repository.AuthorRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path = "/api/v1/authors")
public class AuthorController {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public @ResponseBody Iterable<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createAuthor(@Valid @RequestBody Author author)  {
        return new ResponseEntity<>(authorRepository.save(author), HttpStatus.CREATED);
    }
}