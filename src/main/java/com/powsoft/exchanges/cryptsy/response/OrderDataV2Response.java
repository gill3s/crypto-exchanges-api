package com.powsoft.exchanges.cryptsy.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.powsoft.exchanges.cryptsy.vo.OrderData;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class OrderDataV2Response {
	
	@JsonProperty("return")
	private Map<String, OrderData> orderData = new HashMap<String, OrderData>();

	public Map<String, OrderData> getOrderData() {
		return orderData;
	}

	public void setOrderData(Map<String, OrderData> orderData) {
		this.orderData = orderData;
	}
	
}
