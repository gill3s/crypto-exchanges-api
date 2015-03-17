package com.powsoft.exchanges.bittrex.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.powsoft.exchanges.bittrex.vo.Order;

import java.util.List;

/**
 * @author Gilles Caidignan
 */
public class GetOrderBookResponse {
    @JsonProperty("buy")
    private List<Order> buyOrders;

    @JsonProperty("sell")
    private List<Order> sellOrders;

    public List<Order> getBuyOrders() {
        return buyOrders;
    }

    public void setBuyOrders(List<Order> buyOrders) {
        this.buyOrders = buyOrders;
    }

    public List<Order> getSellOrders() {
        return sellOrders;
    }

    public void setSellOrders(List<Order> sellOrders) {
        this.sellOrders = sellOrders;
    }
}
