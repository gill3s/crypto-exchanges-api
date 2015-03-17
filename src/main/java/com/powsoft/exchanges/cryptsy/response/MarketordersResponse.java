package com.powsoft.exchanges.cryptsy.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.powsoft.exchanges.cryptsy.vo.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class MarketordersResponse {
	
	@JsonProperty("sellorders")
	private List<Order> sellOrders = new ArrayList<Order>();
	
	@JsonProperty("buyorders")
	private List<Order> buyOrders = new ArrayList<Order>();

	public List<Order> getSellOrders() {
		return sellOrders;
	}

	public void setSellOrders(List<Order> sellOrders) {
		this.sellOrders = sellOrders;
	}

	public List<Order> getBuyOrders() {
		return buyOrders;
	}

	public void setBuyOrders(List<Order> buyOrders) {
		this.buyOrders = buyOrders;
	}
	
}
