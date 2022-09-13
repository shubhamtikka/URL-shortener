package com.example.URLshortener.controller;

import com.example.URLshortener.dto.UrlErrorResponseDto;
import com.example.URLshortener.dto.UrlResponseDto;
import com.example.URLshortener.model.Url;
import com.example.URLshortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("url/v1/shortener")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @GetMapping("{id}")
    public ResponseEntity<?> getOriginalUrl(@PathVariable String id, HttpServletResponse response) throws IOException {
        if(urlService.getOriginalUrl(id).isPresent()){
            response.sendRedirect(urlService.getOriginalUrl(id).get().getOriginalUrl());
            return null;
        } else {
            UrlErrorResponseDto errorDto = new UrlErrorResponseDto();
            errorDto.setStatus("400");
            errorDto.setError("Url does not exist");
            return new ResponseEntity<UrlErrorResponseDto>(errorDto, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<?> getShortUrl(@RequestBody String originalUrl){
        Url url = urlService.generateShortUrl(originalUrl);
        String currentPath = ServletUriComponentsBuilder
                .fromCurrentRequest().build().toUri().toString();
        String shortUrl = currentPath +"/"+ url.getShortUrlId();
        UrlResponseDto responseDto = new UrlResponseDto(url, shortUrl);
        return new ResponseEntity<UrlResponseDto>(responseDto,HttpStatus.OK);
    }

}
