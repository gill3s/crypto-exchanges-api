package com.powsoft.exchanges.cryptsy.request;

import com.fasterxml.jackson.databind.JsonNode;
import com.powsoft.exchanges.cryptsy.CryptsyRequest;
import com.powsoft.exchanges.cryptsy.response.GetWalletStatusResponse;

/**
 * Authenticated API <b>getwalletstatus</b><br>
 * For more detail: <a href="https://www.cryptsy.com/pages/privateapi">https://www.cryptsy.com/pages/privateapi</a>
 * @author opsun
 * @since 1.0, 2014-6-5
 */
public class GetWalletStatusRequest extends CryptsyRequest<GetWalletStatusResponse> {

	@Override
	public String getMethod() {
		return "getwalletstatus";
	}

	@Override
	public GetWalletStatusResponse parse(JsonNode json) {
		return null;
	}

}
