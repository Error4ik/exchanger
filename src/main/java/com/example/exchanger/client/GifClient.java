package com.example.exchanger.client;

import com.example.exchanger.domain.Gif;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;


@FeignClient(name = "gif", url = "${feign.client.giphy.url}")
public interface GifClient {

    @GetMapping("/random")
    ResponseEntity<Gif> getRandomGif(@RequestParam(name = "api_key") String apiKey, @RequestParam(name = "tag") String tag);

    @GetMapping
    ResponseEntity<byte[]> getGifBytes(URI url);
}
