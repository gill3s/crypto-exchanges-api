package com.powsoft.exchanges.bittrex.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author Gilles Caidignan
 */
public class Trade {
    @JsonProperty("Id")
    private String id;

    @JsonProperty("TimeStamp")
    private Date timeStamp;

    @JsonProperty("Quantity")
    private double quantity;

    @JsonProperty("Price")
    private double price;

    @JsonProperty("Total")
    private double total;

    @JsonProperty("FillType")
    private String fillType;

    @JsonProperty("OrderType")
    private String orderType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFillType() {
        return fillType;
    }

    public void setFillType(String fillType) {
        this.fillType = fillType;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
