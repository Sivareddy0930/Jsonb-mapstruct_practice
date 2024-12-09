package com.jsonbinary.dto;

public class FilterDto {

    private String title;
    private String author;
    private String country;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public FilterDto(String title, String author, String country) {
        this.title = title;
        this.author = author;
        this.country = country;
    }

    public FilterDto() {
    }


}
