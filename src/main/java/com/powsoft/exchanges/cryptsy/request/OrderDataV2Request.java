package com.powsoft.exchanges.cryptsy.request;

import com.fasterxml.jackson.databind.JsonNode;
import com.powsoft.exchanges.cryptsy.CryptsyRequest;
import com.powsoft.exchanges.cryptsy.response.OrderDataV2Response;
import com.powsoft.exchanges.utils.ParseUtils;

/**
 * public API <b>orderdatav2</b><br>
 * http://pubapi.cryptsy.com/api.php?method=orderdatav2
 * @author opsun
 * @since 1.0, 2014-6-5
 */
public class OrderDataV2Request extends CryptsyRequest<OrderDataV2Response> {

	@Override
	public String getMethod() {
		return "orderdatav2";
	}
	
	@Override
	public boolean auth() {
		return false;
	}
	
	@Override
	public OrderDataV2Response parse(JsonNode json) {
		JsonNode rs = ParseUtils.pack(json, "return");
		return super.parse(rs);
	}
}
