package com.powsoft.exchanges.bittrex.request;

import com.powsoft.exchanges.bittrex.BittrexRequest;
import com.powsoft.exchanges.bittrex.response.GetMarketHistoryResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gilles Caidignan
 */
public class GetMarketHistoryRequest extends BittrexRequest<GetMarketHistoryResponse> {

    private String marketId;

    @Override
    public String getMethod() {
        return "getmarkethistory";
    }

    @Override
    public boolean auth() {
        return false;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    @Override
    public Map<String, String> getParams() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("market", marketId);

        return map;
    }
}