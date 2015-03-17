package com.powsoft.exchanges.bittrex.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.powsoft.exchanges.bittrex.vo.MarketSummary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gilles Caidignan
 */
public class GetMarketSummaryResponse {
    @JsonProperty("result")
    private List<MarketSummary> summaryList = new ArrayList<MarketSummary>();

    public List<MarketSummary> getSummaryList() {
        return summaryList;
    }

    public void setSummaryList(List<MarketSummary> summaryList) {
        this.summaryList = summaryList;
    }

    public MarketSummary getMarketSummary() {
        return this.summaryList.get(0);
    }
}
