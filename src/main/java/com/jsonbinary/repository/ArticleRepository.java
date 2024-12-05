package com.jsonbinary.repository;

//import by.andd3dfx.templateapp.persistence.entities.Article;
import com.jsonbinary.entity.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends CrudRepository<com.jsonbinary.entity.Article, Long> {
    @Query(value = "SELECT * FROM articles a WHERE a.location @> :location::jsonb", nativeQuery = true)
    List<Article> getArticleByCountryNCity(String location);
}
