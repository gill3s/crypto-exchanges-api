package com.powsoft.exchanges.bittrex.request;

import com.powsoft.exchanges.bittrex.BittrexRequest;
import com.powsoft.exchanges.bittrex.response.GetMarketsResponse;

/**
 * Authenticated API <b>getmarkets</b><br>
 * For more detail: <a href="https://www.cryptsy.com/pages/privateapi">https://www.cryptsy.com/pages/privateapi</a>
 *
 * @author opsun
 * @since 1.0, 2014-6-5
 */
public class GetMarketsRequest extends BittrexRequest<GetMarketsResponse> {

    @Override
    public String getMethod() {
        return "getmarkets";
    }

    @Override
    public boolean auth() {
        return false;
    }

}
