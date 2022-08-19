package com.informatorio.noticiasapi.service;

import java.util.Objects;
import com.informatorio.noticiasapi.entity.Source;
import com.informatorio.noticiasapi.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SourceService {
    private final SourceRepository sourceRepository;

    @Autowired
    public SourceService(SourceRepository sourceRepository) {
        this.sourceRepository = sourceRepository;
    }

    public Iterable<Source> findAll() {
        return sourceRepository.findAll();
    }

    public Source findById(Long id) {
        return sourceRepository.getById(id);
    }

    public Source saveOrUpdate(Source source) {
        return sourceRepository.save(source);
    }

    public void deleteSource(Long id) {
        Source source = sourceRepository.getById(id);
        sourceRepository.delete(source);
    }
}