package com.powsoft.exchanges.cryptsy.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.powsoft.exchanges.cryptsy.vo.MyTransaction;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class MyTransactionsResponse {
	@JsonProperty("return")
	private List<MyTransaction> transactions = new ArrayList<MyTransaction>();

	public List<MyTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<MyTransaction> transactions) {
		this.transactions = transactions;
	}
	
}
