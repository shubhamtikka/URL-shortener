package com.example.URLshortener.UrlLib;

import com.google.common.hash.Hashing;
import org.apache.commons.validator.routines.UrlValidator;

import java.nio.charset.Charset;

public class UrlHelper {
    public static boolean isValid(String url) {
        return UrlValidator.getInstance().isValid(url);
    }

    public static String generateShortUrl(String originalUrl){
        String shortUrl = Hashing.murmur3_32_fixed().hashString(originalUrl, Charset.defaultCharset()).toString();
        return shortUrl;
    }
}
