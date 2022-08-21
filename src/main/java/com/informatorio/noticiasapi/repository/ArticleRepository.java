package com.informatorio.noticiasapi.repository;

import java.util.List;
import com.informatorio.noticiasapi.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query("select u from Article u where u.title like %?1% or u.description like %?1% or u.content like %?1%")
    List<Article> findByTitle(String search);
}