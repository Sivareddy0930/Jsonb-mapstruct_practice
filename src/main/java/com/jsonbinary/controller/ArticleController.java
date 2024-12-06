package com.jsonbinary.controller;

import com.jsonbinary.dto.ApiResponse;
import com.jsonbinary.dto.ArticleDto;
import com.jsonbinary.entity.Article;
import com.jsonbinary.service.ArticleServiceInterface;

import com.jsonbinary.service.impl.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleController {
//
    @Autowired
    private ArticleServiceInterface articleService;

    @PostMapping("/create")
    public ResponseEntity<ArticleDto> createArticle( @RequestBody @Valid ArticleDto articleDto){
//        System.out.println("Received ArticleDto:" + articleDto);
        ArticleDto savedArticleDto = articleService.create(articleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticleDto);
    }

    @GetMapping("getArticle/{id}")
    public ResponseEntity<ArticleDto> getArticle(@PathVariable Long id){
        ArticleDto articleDto = articleService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(articleDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity<ApiResponse> getAllArticle(){
        ApiResponse apiResponse = articleService.getAllArticles();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/getAllBySort/{value}")
    public ResponseEntity<ApiResponse> getAllArticleInSorting(@PathVariable String value){
        ApiResponse apiResponse = articleService.getArticlesBySorting(value);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }


    @GetMapping("/pagination/{pageNumber}/{pageSize}")
    public ResponseEntity<ApiResponse> getAllArticleByPagination(@PathVariable int pageNumber, @PathVariable int pageSize){
        ApiResponse apiResponse = articleService.getArticlesWithPagination(pageNumber, pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/paginationAndSorting/{pageNumber}/{pageSize}/{value}")
    public ResponseEntity<ApiResponse> getAllArticleByPaginationAndSorting(@PathVariable int pageNumber, @PathVariable int pageSize,@PathVariable String value){
        ApiResponse apiResponse = articleService.getArticlesWithPaginationAndSorting(pageNumber, pageSize,value);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }


}
