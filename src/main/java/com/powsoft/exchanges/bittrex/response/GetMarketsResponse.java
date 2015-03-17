package com.powsoft.exchanges.bittrex.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.powsoft.exchanges.bittrex.vo.Market;

import java.util.ArrayList;
import java.util.List;

/**
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class GetMarketsResponse {

    @JsonProperty("result")
    private List<Market> markets = new ArrayList<Market>();

    public List<Market> getMarkets() {
        return markets;
    }

    public void setMarkets(List<Market> markets) {
        this.markets = markets;
    }


}
