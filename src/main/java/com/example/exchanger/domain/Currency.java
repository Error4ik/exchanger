package com.example.exchanger.domain;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;


public class Currency {

    private String disclaimer;
    private String license;
    private LocalDate timestamp;
    private String base;
    private Map<String, String> rates;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return
                Objects.equals(disclaimer, currency.disclaimer)
                        && Objects.equals(license, currency.license)
                        && Objects.equals(timestamp, currency.timestamp)
                        && Objects.equals(base, currency.base)
                        && Objects.equals(rates, currency.rates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disclaimer, license, timestamp, base, rates);
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, String> getRates() {
        return rates;
    }

    public void setRates(Map<String, String> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "Exchanger{" +
                "disclaimer='" + disclaimer + '\'' +
                ", license='" + license + '\'' +
                ", timestamp=" + timestamp +
                ", base='" + base + '\'' +
                ", rates=" + rates +
                '}';
    }
}
