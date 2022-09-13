package com.example.URLshortener.repository;

import com.example.URLshortener.model.Url;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UrlRepositoryImpl implements UrlRepository {

    List<Url> urlList =  new ArrayList<>();


    @Override
    public Optional<Url> getOriginalUrl(String shortUrl) {
        return urlList.stream().filter(url -> url.getShortUrlId().equals(shortUrl)).findFirst();
    }

    @Override
    public Url saveUrl(Url url) {
        urlList.add(url);
        return url;
    }
}
