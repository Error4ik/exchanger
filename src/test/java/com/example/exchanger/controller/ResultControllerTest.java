package com.example.exchanger.controller;

import com.example.exchanger.service.CurrencyCompareService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ResultControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CurrencyCompareService currencyCompareService;

    @Test
    public void whenMappingCurrencyShouldReturnStatusIsOk() throws Exception {
        String currencyCode = "amd";
        this.mockMvc.perform(get("/api/v1/currency")
                .param("currency_code", currencyCode))
                .andExpect(status().isOk());
    }
}