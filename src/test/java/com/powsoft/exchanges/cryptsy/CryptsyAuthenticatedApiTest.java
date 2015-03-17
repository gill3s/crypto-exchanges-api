package com.powsoft.exchanges.cryptsy;

import com.powsoft.exchanges.cryptsy.request.*;
import com.powsoft.exchanges.cryptsy.response.*;
import junit.framework.TestCase;
import org.junit.Ignore;

@Ignore
public class CryptsyAuthenticatedApiTest extends TestCase {

    //
	private AuthenticatedCryptsyAPI api = new AuthenticatedCryptsyAPI("public key", "private key");
	
	public void testGetinfo() throws Exception{
		GetInfoResponse response = api.execute(new GetInfoRequest());
		System.out.println(response.getBalancesAvailable().size());
	}
	
	public void testGetmarkets() throws Exception{
		GetMarketsResponse response = api.execute(new GetMarketsRequest());
		System.out.println(response.getActiveMarkets().size());
	}
	
	public void testGetwalletstatus() throws Exception{
		GetWalletStatusResponse response = api.execute(new GetWalletStatusRequest());
		System.out.println(response);
	}
	
	public void testMytransactions() throws Exception{
		MyTransactionsResponse response =  api.execute(new MyTransactionsRequest());
		System.out.println(response);
	}
	
	public void testMarkettrades() throws Exception{
		MarketTradesResponse response = api.execute(new MarketTradesRequest(94));
		System.out.println(response);
	}
	
	public void testMarketorders() throws Exception{
		MarketordersResponse response = api.execute(new MarketOrdersRequest(94));
		System.out.println(response);
	}
	
	public void testMyTrades() throws Exception{
		MyTradesResponse response = api.execute(new MyTradesRequest(132));
		System.out.println(response);
	}
	
	public void testAllmytrades() throws Exception{
		AllMyTradesResponse response = api.execute(new AllMyTradesRequest());
		System.out.println(response.getTrades().size());
	}
	
	public void testMyorders() throws Exception{
		MyOrdersResponse response = api.execute(new MyOrdersRequest(132));
		System.out.println(response.getOrders().size());
	}
	
	public void testAllmyorders() throws Exception{
		AllMyOrdersResponse response = api.execute(new AllMyOrdersRequest());
		System.out.println(response.getOrders().size());
	}
	
	public void testDepth() throws Exception{
		DepthResponse response = api.execute(new DepthRequest(132));
		System.out.println(response);
	}
	
	public void testCancelOrder() throws Exception{
		boolean response = api.execute(new CancelOrderRequest(99822605));
		System.out.println(response);
	}
	
	public void testCreateorder() throws Exception{
		CreateOrderRequest request = new CreateOrderRequest();
		request.setMarketId(132);
		request.setOrderType(CreateOrderRequest.SELL);
		request.setPrice(0.00000357);
		request.setQuantity(1000);
		
		int id = api.execute(request);
		System.out.println(id);
	}
	
	public void testMytransfers() throws Exception{
		MyTransfersResponse response = api.execute(new MyTransfersRequest());
		System.out.println(response);
	}
	
	public void testGetmydepositaddresses() throws Exception{
		GetMyDepositAddressesResponse response = api.execute(new GetMyDepositAddressesRequest());
		System.out.println(response.getDepositAddresses());
	}
	
	public void testGeneratenewaddress() throws Exception{
		GenerateNewAddressRequest request = new GenerateNewAddressRequest();
		request.setCurrencyId(3);
		//request.setCurrencyCode("BTC");
		String addr = api.execute(request);
		System.out.println(addr);
	}
	
	public void testCalculateFees() throws Exception{
		CalculateFeesResponse response = api.execute(new CalculateFeesRequest(CalculateFeesRequest.BUY,100,0.000345d));
		System.out.println("fee:"+response.getFee()+",net:"+response.getNet());
	}
}
