package com.powsoft.exchanges.cryptsy.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.powsoft.exchanges.cryptsy.vo.MyTransfer;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-7
 */
public class MyTransfersResponse {
	
	@JsonProperty("return")
	private List<MyTransfer> transfers = new ArrayList<MyTransfer>();

	public List<MyTransfer> getTransfers() {
		return transfers;
	}

	public void setTransfers(List<MyTransfer> transfers) {
		this.transfers = transfers;
	}
	
}
