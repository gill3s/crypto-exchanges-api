package com.powsoft.exchanges.bittrex.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author opsun
 * @since 1.0, 2014-6-5
 */
public class Order {
    @JsonProperty("Quantity")
    private double quantity;

    @JsonProperty("Rate")
    private double rate;

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
