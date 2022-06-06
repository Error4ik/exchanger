package com.example.exchanger.client;

import com.example.exchanger.domain.Currency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "currency", url = "${feign.client.openexchangerates.url}")
public interface CurrencyClient {

    @GetMapping("/latest.json")
    ResponseEntity<Currency> getCurrentCurrency(@RequestParam(name = "app_id") String appId);

    @GetMapping("/historical/{date}.json")
    ResponseEntity<Currency> getHistoricalCurrency(@PathVariable(name = "date") String date, @RequestParam(name = "app_id") String appId);
}
