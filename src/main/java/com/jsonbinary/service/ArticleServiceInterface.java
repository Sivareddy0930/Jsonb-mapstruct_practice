package com.jsonbinary.service;

import com.jsonbinary.dto.ArticleDto;

import java.util.List;

public interface ArticleServiceInterface {

    ArticleDto create(ArticleDto articleDto);

    ArticleDto getById(Long id);

    List<ArticleDto> getAllArticles();
}
