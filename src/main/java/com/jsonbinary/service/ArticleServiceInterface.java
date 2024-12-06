package com.jsonbinary.service;

import com.jsonbinary.dto.ApiResponse;
import com.jsonbinary.dto.ArticleDto;

import java.util.List;

public interface ArticleServiceInterface {

    ArticleDto create(ArticleDto articleDto);

    ArticleDto getById(Long id);

    ApiResponse getAllArticles();

    ApiResponse getArticlesBySorting(String value);

    ApiResponse getArticlesWithPagination(int pageNumber, int pageSize);

    ApiResponse getArticlesWithPaginationAndSorting(int pageNumber, int pageSize,String value);
}
