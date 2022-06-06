package com.example.exchanger.service;

import com.example.exchanger.client.CurrencyClient;
import com.example.exchanger.domain.Currency;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * TODO: comment.
 *
 * @author Alexey Voronin.
 * @since 05.06.2022.
 */
class CurrencyServiceTest {

    private String feignAppId = "id";
    private final CurrencyClient currencyClient = mock(CurrencyClient.class);
    private final ResponseEntity responseEntity = mock(ResponseEntity.class);

    private final CurrencyService currencyService = new CurrencyService(feignAppId, currencyClient);
    private final Currency currency = new Currency();

    @Test
    public void whenGetCurrentCurrencyShouldReturnCurrency() throws Exception {
        when(currencyClient.getCurrentCurrency(anyString())).thenReturn(responseEntity);
        when(responseEntity.getBody()).thenReturn(currency);

        Currency actualValue = currencyService.getCurrentCurrency();

        assertSame(currency, actualValue);
        verify(currencyClient, times(1)).getCurrentCurrency(anyString());
    }

    @Test
    public void whenGetHistoricalCurrencyShouldReturnCurrency() throws Exception {
        when(currencyClient.getHistoricalCurrency(anyString(), anyString())).thenReturn(responseEntity);
        when(responseEntity.getBody()).thenReturn(currency);

        Currency actualValue = currencyService.getHistoricalCurrency();

        assertSame(currency, actualValue);
        verify(currencyClient, times(1)).getHistoricalCurrency(anyString(), anyString());
    }
}