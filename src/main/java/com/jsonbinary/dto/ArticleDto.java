package com.jsonbinary.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)//indicate which properties need to serialize.
public class ArticleDto {
    private Long id;

    @NotNull(message = "Title should be populated")
    @Size(min = 1, max = 100, message = "Title length must be between 1 and 100")
    private String title;

    @Size(max = 255, message = "Summary length shouldn't be greater than 255")
    private String summary;

    @NotNull(message = "Text should be populated")
    @Size(min = 1, message = "Text length should be 1 at least")
    private String text;

    @NotNull(message = "Author should be populated")
    private String author;

    private Map<String, Object> location;

    private MobileDto mobileDto;

        @Null(message = "DateCreated shouldn't be populated")
    private LocalDateTime dateCreated;

    @Null(message = "DateUpdated shouldn't be populated")
    private LocalDateTime dateUpdated;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Map<String, Object> getLocation() {
        return location;
    }

    public void setLocation(Map<String, Object> location) {
        this.location = location;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public MobileDto getMobileDto() {
        return mobileDto;
    }

    public void setMobileDto(MobileDto mobileDto) {
        this.mobileDto = mobileDto;
    }
}
