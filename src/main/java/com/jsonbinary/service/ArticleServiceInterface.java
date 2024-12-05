package com.jsonbinary.service;

import com.jsonbinary.dto.ArticleDto;

public interface ArticleServiceInterface {

    ArticleDto create(ArticleDto articleDto);

    ArticleDto getById(Long id);

}
