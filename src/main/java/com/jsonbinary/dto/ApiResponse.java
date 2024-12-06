package com.jsonbinary.dto;

import java.util.List;

public class ApiResponse {

    private Integer count;
   private List<ArticleDto> articleDtoList;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ArticleDto> getArticleDtoList() {
        return articleDtoList;
    }

    public void setArticleDtoList(List<ArticleDto> articleDtoList) {
        this.articleDtoList = articleDtoList;
    }

    public ApiResponse(Integer count, List<ArticleDto> articleDtoList) {
        this.count = count;
        this.articleDtoList = articleDtoList;
    }

    public ApiResponse() {
    }
}
