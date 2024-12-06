package com.jsonbinary.service.impl;

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

//        Article article = new Article();
//        article.setMobile(new Mobile( articleDto.getMobileDto().getPersonalNumber(), articleDto.getMobileDto().getWorkNumber()));
//        article.setId( articleDto.getId() );
//        article.setTitle( articleDto.getTitle() );
//        article.setSummary( articleDto.getSummary() );
//        article.setText( articleDto.getText() );
//        article.setAuthor( articleDto.getAuthor() );


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
    public List<ArticleDto> getAllArticles() {
        Iterable<Article> articles = articleRepository.findAll();
        List<ArticleDto> articleDtoList = new ArrayList<>();
        for (Article article : articles){
            ArticleDto articleDto = articleMapper.toArticleDto(article);
            articleDtoList.add(articleDto);
        }
        return articleDtoList;
    }
}
