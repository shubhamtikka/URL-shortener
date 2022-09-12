package com.example.URLshortener.controller;

import com.example.URLshortener.model.Url;
import com.example.URLshortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("url/v1/shortener")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @GetMapping("{id}")
    public void getOriginalUrl(@PathVariable String id, HttpServletResponse response) throws IOException {
        response.sendRedirect(urlService.getOriginalUrl(id).getOriginalUrl());
    }

    @PostMapping
    public Url getShortUrl(@RequestBody String originalUrl){
        return urlService.generateShortUrl(originalUrl);
    }

}
