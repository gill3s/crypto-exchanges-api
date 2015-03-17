package com.powsoft.exchanges.cryptsy.request;

import com.fasterxml.jackson.databind.JsonNode;
import com.powsoft.exchanges.cryptsy.CryptsyRequest;
import com.powsoft.exchanges.cryptsy.response.AllMyTradesResponse;
import com.powsoft.exchanges.utils.Assert;
import com.powsoft.exchanges.utils.ParseUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Authenticated API <b>allmytrades</b><br>
 * For more detail: <a href="https://www.cryptsy.com/pages/privateapi">https://www.cryptsy.com/pages/privateapi</a>
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class AllMyTradesRequest extends CryptsyRequest<AllMyTradesResponse>{
	//Starting date for query (format: yyyy-mm-dd)
	private String startDate;
	
	//Ending date for query (format: yyyy-mm-dd)
	private String endDate;
	
	public String getStartDate() {
		return startDate;
	}

	/**
	 * Starting date for query (format: yyyy-mm-dd)
	 * @param startDate
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}
	
	/**
	 * Ending date for query (format: yyyy-mm-dd)
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String getMethod() {
		return "allmytrades";
	}
	
	@Override
	public Map<String, String> getParams() {
		Map<String, String> map = new HashMap<String, String>();
		if(!Assert.isEmpty(startDate)){
			map.put("startdate", startDate);
		}
		
		if(!Assert.isEmpty(endDate)){
			map.put("enddate", endDate);
		}
		
		return super.getParams();
	}
	
	@Override
	public AllMyTradesResponse parse(JsonNode json) {
		json = ParseUtils.pack(json, "return");
		return super.parse(json);
	}

}
