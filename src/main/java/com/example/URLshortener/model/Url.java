package com.example.URLshortener.model;

import java.time.LocalDateTime;

public class Url {
    private int id;
    private String shortUrlId;
    private String originalUrl;

    private LocalDateTime dateCreated;

    public Url(){}

    public Url(String shortUrlId, String originalUrl) {
        this.shortUrlId = shortUrlId;
        this.originalUrl = originalUrl;
    }

    public int getId() {
        return id;
    }
    public String getShortUrlId() {
        return shortUrlId;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setShortUrlId(String shortUrlId) {
        this.shortUrlId = shortUrlId;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", shortUrl='" + shortUrlId + '\'' +
                ", originalUrl='" + originalUrl + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
