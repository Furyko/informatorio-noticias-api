package com.informatorio.noticiasapi.controller;

import java.time.LocalDate;
import javax.validation.Valid;
import com.informatorio.noticiasapi.entity.Author;
import com.informatorio.noticiasapi.service.AuthorService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.format.annotation.DateTimeFormat;

@RestController
@RequestMapping(path = "/api/v1/authors")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public @ResponseBody Iterable<Author> getAuthors(
        @RequestParam(name = "name", required = false) String name,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate after
    ) {
        if (name != null) {
            return authorService.findByName(name);
        } else if (after != null) {
            return authorService.findAfter(after);
        }
        return authorService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createAuthor(@Valid @RequestBody Author author) {
        Author newAuthor = authorService.saveOrUpdate(author);
        return new ResponseEntity<Author>(newAuthor, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public void deleteAuthor(@PathVariable("id") Long id) {
        authorService.deleteAuthor(id);
    }
}