package com.example.URLshortener.service;

import com.example.URLshortener.model.Url;
import org.springframework.web.bind.annotation.PathVariable;

public interface UrlService {

    public Url getOriginalUrl(String id);
    public Url generateShortUrl(String id);

}
