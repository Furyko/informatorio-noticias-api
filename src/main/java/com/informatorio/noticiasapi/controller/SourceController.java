package com.informatorio.noticiasapi.controller;

import javax.validation.Valid;
import com.informatorio.noticiasapi.entity.Source;
import com.informatorio.noticiasapi.repository.SourceRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path = "/api/v1/sources")
public class SourceController {
    private final SourceRepository sourceRepository;

    @Autowired
    public SourceController(SourceRepository sourceRepository) {
        this.sourceRepository = sourceRepository;
    }

    @GetMapping
    public @ResponseBody Iterable<Source> getSources() {
        return sourceRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createSource(@Valid @RequestBody Source source)  {
        return new ResponseEntity<>(sourceRepository.save(source), HttpStatus.CREATED);
    }
}