package com.jsonbinary.mapper;

import com.jsonbinary.dto.ArticleDto;
import com.jsonbinary.dto.MobileDto;
import com.jsonbinary.entity.Article;
import com.jsonbinary.entity.Mobile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    // Explicitly map the 'mobile' field in Article to 'mobileDto' in ArticleDto
    @Mapping(source = "mobile", target = "mobileDto")
    ArticleDto toArticleDto(Article article);

    // Explicitly map the 'mobileDto' field in ArticleDto to 'mobile' in Article
    @Mapping(source = "mobileDto", target = "mobile")
    Article toArticle(ArticleDto articleDto);
}
