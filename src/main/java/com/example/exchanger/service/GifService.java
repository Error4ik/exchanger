package com.example.exchanger.service;

import com.example.exchanger.client.GifClient;
import com.example.exchanger.domain.Gif;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Map;


@Service
public class GifService {

    private final GifClient gifClient;

    private final String gifApiKey;

    public GifService(@Value("${gif.api.key}") String gifApiKey, GifClient gifClient) {
        this.gifApiKey = gifApiKey;
        this.gifClient = gifClient;
    }

    public String getGifUrl(String tag) {
        ResponseEntity<Gif> randomGif = gifClient.getRandomGif(gifApiKey, tag);
        return getUrl(randomGif);
    }

    public ResponseEntity<byte[]> getGifBytes(URI url) {
        return this.gifClient.getGifBytes(url);
    }

    private String getUrl(ResponseEntity<Gif> responseEntity) {
        String url = (String) ((Map) ((Map) responseEntity.getBody().getData().get("images")).get("original")).get("url");
        return url;
    }
}
