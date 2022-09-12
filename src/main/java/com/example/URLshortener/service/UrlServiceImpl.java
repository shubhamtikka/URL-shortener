package com.example.URLshortener.service;

import com.example.URLshortener.UrlLib.UrlHelper;
import com.example.URLshortener.model.Url;
import com.example.URLshortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.time.LocalDateTime;

@Service
public class UrlServiceImpl implements UrlService{

    @Autowired
    UrlRepository repository;
    @Override
    public Url getOriginalUrl(String shortUrl) {
        return  repository.getOriginalUrl(shortUrl).orElse(new Url(shortUrl, null));
    }

    @Override
    public Url generateShortUrl(String originalUrl) {
        if(UrlHelper.isValid(originalUrl)) {
            Url url = new Url();
            LocalDateTime dateCreated = LocalDateTime.now();

            url.setOriginalUrl(originalUrl);
            url.setDateCreated(dateCreated);

            String shortUrl = UrlHelper.generateShortUrl(originalUrl + dateCreated.toString());

            url.setShortUrl(shortUrl);

            return repository.saveUrl(url);
        } else {
            return new Url(null, originalUrl);
        }

    }
}
