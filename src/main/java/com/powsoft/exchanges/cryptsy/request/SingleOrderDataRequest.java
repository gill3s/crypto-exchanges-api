package com.powsoft.exchanges.cryptsy.request;

import com.fasterxml.jackson.databind.JsonNode;
import com.powsoft.exchanges.cryptsy.CryptsyRequest;
import com.powsoft.exchanges.cryptsy.response.SingleOrderDataResponse;
import com.powsoft.exchanges.cryptsy.utils.ParseUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * public API <b>singleorderdata</b><br>
 * http://pubapi.cryptsy.com/api.php?method=singleorderdata&amp;marketid=xx
 * @author opsun
 * @since 1.0, 2014-6-5
 */
public class SingleOrderDataRequest extends CryptsyRequest<SingleOrderDataResponse>{
	private int marketId;
	

	public int getMarketId() {
		return marketId;
	}

	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}

	@Override
	public String getMethod() {
		return "singleorderdata";
	}
	
	@Override
	public boolean auth() {
		return false;
	}
	
	@Override
	public Map<String, String> getParams() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("marketid", marketId+"");
		return params;
	}
	
	@Override
	public SingleOrderDataResponse parse(JsonNode json) {
		SingleOrderDataResponse response = new SingleOrderDataResponse();
		Iterator<?> iterator = json.elements();
		if(iterator.hasNext()){
			response = ParseUtils.convertValue(iterator.next(),SingleOrderDataResponse.class);
		}
		
		return response;
	}

}
