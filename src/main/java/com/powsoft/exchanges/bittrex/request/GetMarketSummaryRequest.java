package com.powsoft.exchanges.bittrex.request;

import com.powsoft.exchanges.bittrex.BittrexRequest;
import com.powsoft.exchanges.bittrex.response.GetMarketSummaryResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gilles Caidignan
 */
public class GetMarketSummaryRequest extends BittrexRequest<GetMarketSummaryResponse> {

    private String marketId;

    @Override
    public String getMethod() {
        return "getmarketsummary";
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
