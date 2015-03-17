package com.powsoft.exchanges.bittrex.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class Market {
    @JsonProperty("MarketName")
    private String marketName;

    @JsonProperty("Notice")
    private String notice;

    @JsonProperty("LogoUrl")
    private String logoUrl;

    @JsonProperty("MarketCurrencyLong")
    private String marketCurrencyLong;

    @JsonProperty("MarketCurrency")
    private String marketCurrency;

    @JsonProperty("BaseCurrencyLong")
    private String baseCurrencyLong;

    @JsonProperty("BaseCurrency")
    private String baseCurrency;

    @JsonProperty("MinTradeSize")
    private double minTradeSize;

    @JsonProperty("IsActive")
    private boolean isActive;

    @JsonProperty("IsSponsored")
    private boolean isSponsored;

    @JsonProperty("Created")
    private Date created;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }


    public String getMarketCurrencyLong() {
        return marketCurrencyLong;
    }

    public void setMarketCurrencyLong(String marketCurrencyLong) {
        this.marketCurrencyLong = marketCurrencyLong;
    }

    public String getMarketCurrency() {
        return marketCurrency;
    }

    public void setMarketCurrency(String marketCurrency) {
        this.marketCurrency = marketCurrency;
    }

    public String getBaseCurrencyLong() {
        return baseCurrencyLong;
    }

    public void setBaseCurrencyLong(String baseCurrencyLong) {
        this.baseCurrencyLong = baseCurrencyLong;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public double getMinTradeSize() {
        return minTradeSize;
    }

    public void setMinTradeSize(double minTradeSize) {
        this.minTradeSize = minTradeSize;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

}
