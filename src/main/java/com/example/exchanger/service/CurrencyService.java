package com.example.exchanger.service;

import com.example.exchanger.client.CurrencyClient;
import com.example.exchanger.domain.Currency;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Service
public class CurrencyService {

    private final String feignAppId;

    private final CurrencyClient currencyClient;

    public CurrencyService(@Value("${feign.app.id}") String feignAppId, CurrencyClient currencyClient) {
        this.feignAppId = feignAppId;
        this.currencyClient = currencyClient;
    }

    public Currency getCurrentCurrency() {
        return currencyClient.getCurrentCurrency(feignAppId).getBody();
    }

    public Currency getHistoricalCurrency() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();
        LocalDate minusDays = now.minusDays(1);
        String yesterday = minusDays.format(formatter);
        return currencyClient.getHistoricalCurrency(yesterday, feignAppId).getBody();
    }
}
