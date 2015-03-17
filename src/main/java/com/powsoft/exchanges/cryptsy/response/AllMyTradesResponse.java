package com.powsoft.exchanges.cryptsy.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.powsoft.exchanges.cryptsy.vo.MyTrade;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class AllMyTradesResponse {
	
	@JsonProperty("return")
	private List<MyTrade> trades = new ArrayList<MyTrade>();

	public List<MyTrade> getTrades() {
		return trades;
	}

	public void setTrades(List<MyTrade> trades) {
		this.trades = trades;
	}
	
}
