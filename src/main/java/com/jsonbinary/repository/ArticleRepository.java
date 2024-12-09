package com.jsonbinary.repository;

//import by.andd3dfx.templateapp.persistence.entities.Article;
import com.jsonbinary.entity.Article;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query(value = "SELECT * FROM articles a WHERE a.location @> :location::jsonb", nativeQuery = true)
    List<Article> getArticleByCountryNCity(String location);

    @Query(value = "SELECT * " +
            "FROM articles a WHERE " +
            "(:title IS NULL OR a.title = :title) " +
            "AND (:author IS NULL OR a.author = :author) " +
            "AND (:country IS NULL OR a.location -> 'Work' ->> 'country' = :country) " +
            "ORDER BY a.date_created ASC " +
            "LIMIT :pageSize OFFSET :offset",
            nativeQuery = true)
    List<Article> getAllArticlesBasedOnFiltersAndPagenationandSorting(@Param("offset") int offset,@Param("pageSize") int pageSize,@Param("title") String title,@Param("author") String author,@Param("country") String country);
}
