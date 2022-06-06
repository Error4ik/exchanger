package com.example.exchanger.service;

import com.example.exchanger.client.GifClient;
import com.example.exchanger.domain.Gif;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * TODO: comment.
 *
 * @author Alexey Voronin.
 * @since 05.06.2022.
 */
class GifServiceTest {

    private final GifClient gifClient = mock(GifClient.class);
    private final ResponseEntity responseEntity = mock(ResponseEntity.class);
    private final Map<String, Object> map = mock(HashMap.class);
    private final Gif gif = mock(Gif.class);

    private String gifApiKey = "key";
    private final String tag = "tag";
    private final String url = "url";
    private final URI uri = URI.create(url);
    private final GifService gifService = new GifService(gifApiKey, gifClient);

    @Test
    void whenGetGifUrlShouldReturnString() {
        when(gifClient.getRandomGif(anyString(), anyString())).thenReturn(responseEntity);
        when(responseEntity.getBody()).thenReturn(gif);
        when(gif.getData()).thenReturn(map);
        when(map.get("images")).thenReturn(map);
        when(map.get("original")).thenReturn(map);
        when(map.get("url")).thenReturn(url);

        String actualValue = gifService.getGifUrl(tag);
        assertSame(url, actualValue);

        verify(gifClient, times(1)).getRandomGif(anyString(), anyString());
    }

    @Test
    void whenGetGifByesShouldReturnResponseEntity() {
        when(gifClient.getGifBytes(uri)).thenReturn(responseEntity);

        ResponseEntity actualValue = gifService.getGifBytes(uri);

        assertSame(responseEntity, actualValue);
        verify(gifClient, times(1)).getGifBytes(uri);
    }
}