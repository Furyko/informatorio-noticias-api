package com.informatorio.noticiasapi.controller;

import javax.validation.Valid;
import com.informatorio.noticiasapi.entity.Source;
import com.informatorio.noticiasapi.service.SourceService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path = "/api/v1/sources")
public class SourceController {
    private final SourceService sourceService;

    @Autowired
    public SourceController(SourceService sourceService) {
        this.sourceService = sourceService;
    }

    @GetMapping
    public @ResponseBody Iterable<Source> getSources() {
        return sourceService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createSource(@Valid @RequestBody Source source)  {
        Source newSource = sourceService.saveOrUpdate(source);
        return new ResponseEntity<Source>(newSource, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public void deleteSource(@PathVariable("id") Long id) {
        sourceService.deleteSource(id);
    }
}