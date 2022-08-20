package com.informatorio.noticiasapi.repository;

import java.util.List;
import com.informatorio.noticiasapi.entity.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface SourceRepository extends JpaRepository<Source, Long> {
    @Query("select u from Source u where u.name like %?1%")
    List<Source> findByName(String name);
}