package com.jsonbinary.service.impl;

import com.jsonbinary.dto.ApiResponse;
import com.jsonbinary.dto.ArticleDto;
import com.jsonbinary.entity.Article;
import com.jsonbinary.entity.Location;
import com.jsonbinary.entity.Mobile;
import com.jsonbinary.mapper.ArticleMapper;
import com.jsonbinary.repository.ArticleRepository;
import com.jsonbinary.service.ArticleServiceInterface;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArticleService implements ArticleServiceInterface {

    @Autowired
    private  ArticleRepository articleRepository;


    private  ArticleMapper articleMapper;

    @Autowired
    public ArticleService(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }


    @Override
    public ArticleDto create(ArticleDto articleDto) {

        Article article = articleMapper.toArticle(articleDto);
        Article savedArticle = articleRepository.save(article);
        ArticleDto savedArticleDto = articleMapper.toArticleDto(savedArticle);
        return savedArticleDto;
    }


    @Override
    public ArticleDto getById(Long id) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        if (!optionalArticle.isPresent()){
            throw new RuntimeException("No Article found with Id");
        }
        Article article = optionalArticle.get();
        return articleMapper.toArticleDto(article);
    }

    @Override
    public ApiResponse getAllArticles() {
        Iterable<Article> articles = articleRepository.findAll();
        List<ArticleDto> articleDtoList = new ArrayList<>();
        for (Article article : articles){
            ArticleDto articleDto = articleMapper.toArticleDto(article);
            articleDtoList.add(articleDto);
        }
        ApiResponse response = new ApiResponse();
        response.setCount(articleDtoList.size());
        response.setArticleDtoList(articleDtoList);
        return response;
    }


    public ApiResponse getArticlesBySorting(String value){
        List<Article> articles = articleRepository.findAll(Sort.by(Sort.Direction.ASC,value));

        List<ArticleDto> articleDtoList = new ArrayList<>();
        for (Article article : articles){
            ArticleDto articleDto = articleMapper.toArticleDto(article);
            articleDtoList.add(articleDto);
        }
        ApiResponse response = new ApiResponse();
        response.setCount(articleDtoList.size());
        response.setArticleDtoList(articleDtoList);
        return response;

    }




    public ApiResponse getArticlesWithPagination(int pageNumber, int pageSize){
        Page<Article> articlePage = articleRepository.findAll(PageRequest.of(pageNumber, pageSize));



        // Convert each article to ArticleDto using the mapper
        List<ArticleDto> articleDtoList = new ArrayList<>();

        for (Article article : articlePage.getContent()) {
            ArticleDto articleDto = articleMapper.toArticleDto(article);
            articleDtoList.add(articleDto);
        }

        ApiResponse response = new ApiResponse();
        response.setCount(articleDtoList.size());
        response.setArticleDtoList(articleDtoList);
        return response;

    }




    public ApiResponse getArticlesWithPaginationAndSorting(int pageNumber, int pageSize,String value){
        Page<Article> articlePage = articleRepository.findAll(PageRequest.of(pageNumber, pageSize).withSort(Sort.Direction.ASC, value));



        // Convert each article to ArticleDto using the mapper
        List<ArticleDto> articleDtoList = new ArrayList<>();

        for (Article article : articlePage.getContent()) {
            ArticleDto articleDto = articleMapper.toArticleDto(article);
            articleDtoList.add(articleDto);
        }

        ApiResponse response = new ApiResponse();
        response.setCount(articleDtoList.size());
        response.setArticleDtoList(articleDtoList);
        return response;

    }
}
