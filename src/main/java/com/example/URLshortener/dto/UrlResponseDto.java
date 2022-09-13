package com.example.URLshortener.dto;

import com.example.URLshortener.model.Url;

public class UrlResponseDto {

    private Url url;
    private String shortUrl;

    public UrlResponseDto(Url url, String shortUrl) {
        this.url = url;
        this.shortUrl = shortUrl;
    }

    @Override
    public String toString() {
        return "UrlResponseDto{" +
                "url=" + url +
                ", shortUrl='" + shortUrl + '\'' +
                '}';
    }

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
