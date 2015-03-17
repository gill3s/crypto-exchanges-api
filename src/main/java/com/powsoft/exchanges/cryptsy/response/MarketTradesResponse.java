package com.powsoft.exchanges.cryptsy.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.powsoft.exchanges.cryptsy.vo.MarketTrade;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class MarketTradesResponse {
	
	@JsonProperty("return")
	private List<MarketTrade> trades = new ArrayList<MarketTrade>();

	public List<MarketTrade> getTrades() {
		return trades;
	}

	public void setTrades(List<MarketTrade> trades) {
		this.trades = trades;
	}
	
}
