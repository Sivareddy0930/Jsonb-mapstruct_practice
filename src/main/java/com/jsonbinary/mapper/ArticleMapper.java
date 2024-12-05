package com.jsonbinary.mapper;

import com.jsonbinary.dto.ArticleDto;
import com.jsonbinary.entity.Article;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    ArticleDto toArticleDto(Article article);

    Article toArticle(ArticleDto articleDto);

}
