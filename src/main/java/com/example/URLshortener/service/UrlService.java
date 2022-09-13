package com.example.URLshortener.service;

import com.example.URLshortener.model.Url;

import java.util.Optional;

public interface UrlService {

    public Optional<Url> getOriginalUrl(String id);
    public Url generateShortUrl(String id);

}
