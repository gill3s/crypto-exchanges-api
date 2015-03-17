package com.powsoft.exchanges.cryptsy.request;

import com.fasterxml.jackson.databind.JsonNode;
import com.powsoft.exchanges.cryptsy.CryptsyRequest;
import com.powsoft.exchanges.cryptsy.response.GetMyDepositAddressesResponse;
import com.powsoft.exchanges.cryptsy.utils.ParseUtils;

/**
 * Authenticated API <b>getmydepositaddresses</b><br>
 * For more detail: <a href="https://www.cryptsy.com/pages/privateapi">https://www.cryptsy.com/pages/privateapi</a>
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class GetMyDepositAddressesRequest extends CryptsyRequest<GetMyDepositAddressesResponse> {

	@Override
	public String getMethod() {
		return "getmydepositaddresses";
	}
	
	@Override
	public GetMyDepositAddressesResponse parse(JsonNode json) {
		json = ParseUtils.pack(json, "return");
		return super.parse(json);
	}

}
