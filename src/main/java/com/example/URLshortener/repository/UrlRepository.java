package com.example.URLshortener.repository;
import com.example.URLshortener.model.Url;

import java.util.Optional;

public interface UrlRepository  {

    public Optional<Url> getOriginalUrl(String shortUrl);
    public Url saveUrl(Url url);
}
