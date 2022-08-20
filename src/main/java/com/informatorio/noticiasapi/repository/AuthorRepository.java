package com.informatorio.noticiasapi.repository;

import java.util.List;
import java.time.LocalDateTime;
import com.informatorio.noticiasapi.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("select u from Author u where u.fullName like %?1%")
    List<Author> findByFullName(String name);
    @Query("from Author where createdAt >= ?1")
    List<Author> findByCreatedAt(LocalDateTime createdAt);
}