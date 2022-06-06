package com.example.exchanger.controller;

import com.example.exchanger.service.CurrencyCompareService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class ResultController {

    private final CurrencyCompareService compareService;

    public ResultController(CurrencyCompareService compareService) {
        this.compareService = compareService;
    }

    @GetMapping(path = "/currency")
    public ResponseEntity<byte[]> getResultGif(@RequestParam(name = "currency_code") String currencyCode) {
        return compareService.compareCurrency(currencyCode);
    }
}
