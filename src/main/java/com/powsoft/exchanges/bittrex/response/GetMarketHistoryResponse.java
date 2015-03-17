package com.powsoft.exchanges.bittrex.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.powsoft.exchanges.bittrex.vo.Trade;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gilles Caidignan
 */
public class GetMarketHistoryResponse {

    @JsonProperty("result")
    private List<Trade> history = new ArrayList<Trade>();

    public List<Trade> getHistory() {
        return history;
    }

    public void setHistory(List<Trade> history) {
        this.history = history;
    }
}
