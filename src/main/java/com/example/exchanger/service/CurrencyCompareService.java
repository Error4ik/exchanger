package com.example.exchanger.service;

import com.example.exchanger.domain.Currency;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;


@Service
public class CurrencyCompareService {

    private final CurrencyService currencyService;
    private final GifService gifService;

    public CurrencyCompareService(CurrencyService currencyService, GifService gifService) {
        this.currencyService = currencyService;
        this.gifService = gifService;
    }

    public ResponseEntity<byte[]> compareCurrency(String currencyCode) {
        Currency today = currencyService.getCurrentCurrency();
        Currency yesterday = currencyService.getHistoricalCurrency();

        double currentValue = Double.parseDouble(today.getRates().get(currencyCode.toUpperCase()));
        double yesterdayValue = Double.parseDouble(yesterday.getRates().get(currencyCode.toUpperCase()));

        URI uri = URI.create(gifService.getGifUrl(getSearchValue(currentValue, yesterdayValue)));

        return this.gifService.getGifBytes(uri);
    }

    private String getSearchValue(double currentValue, double yesterdayValue) {
        return currentValue < yesterdayValue ? "broke" : "rich";
    }
}
