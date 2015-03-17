package com.powsoft.exchanges.cryptsy.request;

import com.fasterxml.jackson.databind.JsonNode;
import com.powsoft.exchanges.cryptsy.CryptsyRequest;
import com.powsoft.exchanges.cryptsy.response.MyTradesResponse;
import com.powsoft.exchanges.cryptsy.vo.MyTrade;

import java.util.HashMap;
import java.util.Map;

/**
 * Authenticated API <b>mytrades</b><br>
 * For more detail: <a href="https://www.cryptsy.com/pages/privateapi">https://www.cryptsy.com/pages/privateapi</a>
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class MyTradesRequest extends CryptsyRequest<MyTradesResponse>{
	private int marketId;
	
	private int limit = 200;

	/**
	 * default limit 200
	 * @param marketId
	 */
	public MyTradesRequest(int marketId) {
		this.marketId = marketId;
	}
	
	public MyTradesRequest(int marketId, int limit) {
		this.marketId = marketId;
		this.limit = limit;
	}

	public int getMarketId() {
		return marketId;
	}

	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public String getMethod() {
		return "mytrades";
	}
	
	@Override
	public Map<String, String> getParams() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("marketid", marketId+"");
		map.put("limit", limit+"");
		return map;
	}
	
	@Override
	public MyTradesResponse parse(JsonNode json) {
		MyTradesResponse response = super.parse(json);
		
		if(response.getTrades()!=null){
			for(MyTrade trade : response.getTrades()){
				trade.setMarketId(marketId);
			}
		}

		
		return response;
	}
	
}
