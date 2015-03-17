package com.powsoft.exchanges.bittrex.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author Gilles Cadignan
 */
public class MarketSummary {

    @JsonProperty("MarketName")
    private String marketName;

    @JsonProperty("High")
    private double high;

    @JsonProperty("Low")
    private double low;

    @JsonProperty("Volume")
    private double volume;

    @JsonProperty("Last")
    private double last;

    @JsonProperty("BaseVolume")
    private double baseVolume;

    @JsonProperty("TimeStamp")
    private Date timeStamp;

    @JsonProperty("Bid")
    private double bid;

    @JsonProperty("Ask")
    private double ask;

    @JsonProperty("OpenBuyOrders")
    private int openBuyOrders;

    @JsonProperty("OpenSellOrders")
    private int openSellOrders;

    @JsonProperty("PrevDay")
    private double prevDay;

    @JsonProperty("Created")
    private Date created;

    @JsonProperty("DisplayMarketName")
    private String displayMarketName;

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getLast() {
        return last;
    }

    public void setLast(double last) {
        this.last = last;
    }

    public double getBaseVolume() {
        return baseVolume;
    }

    public void setBaseVolume(double baseVolume) {
        this.baseVolume = baseVolume;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public int getOpenBuyOrders() {
        return openBuyOrders;
    }

    public void setOpenBuyOrders(int openBuyOrders) {
        this.openBuyOrders = openBuyOrders;
    }

    public int getOpenSellOrders() {
        return openSellOrders;
    }

    public void setOpenSellOrders(int openSellOrders) {
        this.openSellOrders = openSellOrders;
    }

    public double getPrevDay() {
        return prevDay;
    }

    public void setPrevDay(double prevDay) {
        this.prevDay = prevDay;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getDisplayMarketName() {
        return displayMarketName;
    }

    public void setDisplayMarketName(String displayMarketName) {
        this.displayMarketName = displayMarketName;
    }
}
