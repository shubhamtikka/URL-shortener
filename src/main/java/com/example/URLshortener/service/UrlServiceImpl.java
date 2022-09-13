package com.example.URLshortener.service;

import com.example.URLshortener.UrlLib.UrlHelper;
import com.example.URLshortener.model.Url;
import com.example.URLshortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UrlServiceImpl implements UrlService{

    @Autowired
    UrlRepository repository;
    @Override
    public Optional<Url> getOriginalUrl(String shortUrlId) {
        return  repository.getOriginalUrl(shortUrlId);
    }

    @Override
    public Url generateShortUrl(String originalUrl) {
        if(UrlHelper.isValid(originalUrl)) {
            Url url = new Url();
            LocalDateTime dateCreated = LocalDateTime.now();
            url.setOriginalUrl(originalUrl);
            url.setDateCreated(dateCreated);
            String setShortUrlId = UrlHelper.generateShortUrl(originalUrl + dateCreated.toString());
            url.setShortUrlId(setShortUrlId);
            return repository.saveUrl(url);
        } else {
            throw new IllegalArgumentException("Url is invalid :"+originalUrl);
        }

    }
}
