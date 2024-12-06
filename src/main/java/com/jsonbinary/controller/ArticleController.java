package com.jsonbinary.controller;

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
    public ResponseEntity<List<ArticleDto>> getAllArticle(){
        List<ArticleDto> articleDto = articleService.getAllArticles();
        return ResponseEntity.status(HttpStatus.OK).body(articleDto);
    }


}
