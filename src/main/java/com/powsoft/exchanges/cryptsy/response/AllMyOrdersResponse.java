package com.powsoft.exchanges.cryptsy.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.powsoft.exchanges.cryptsy.vo.MyOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class AllMyOrdersResponse {
	
	@JsonProperty("return")
	private List<MyOrder> orders = new ArrayList<MyOrder>();

	public List<MyOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<MyOrder> orders) {
		this.orders = orders;
	}
	
}
