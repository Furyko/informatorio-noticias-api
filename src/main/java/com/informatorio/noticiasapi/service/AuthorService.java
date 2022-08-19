package com.informatorio.noticiasapi.service;

import java.util.Objects;
import com.informatorio.noticiasapi.entity.Author;
import com.informatorio.noticiasapi.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findById(Long id) {
        return authorRepository.getById(id);
    }

    public Author saveOrUpdate(Author author) {
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        Author author = authorRepository.getById(id);
        authorRepository.delete(author);
    }
}