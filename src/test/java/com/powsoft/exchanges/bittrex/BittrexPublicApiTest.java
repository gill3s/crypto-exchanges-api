package com.powsoft.exchanges.bittrex;

import com.powsoft.exchanges.CryptoExchangeFactory;
import com.powsoft.exchanges.ExchangeException;
import com.powsoft.exchanges.PublicExchangeApi;
import com.powsoft.exchanges.model.*;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BittrexPublicApiTest {
    private PublicExchangeApi api = CryptoExchangeFactory.getPublicExchangeApi(ExchangeEnum.BITTREX);

    @Test
    public void testGetExchangeName() throws ExchangeException {
        ExchangeEnum exch = api.getExchange();
        assertEquals(ExchangeEnum.BITTREX, exch);
    }

    @Test
    public void testGetExchangeMarkets() throws ExchangeException {
        List<Market> markets = api.getExchangeMarkets();
        assertTrue(!markets.isEmpty());
    }

    @Test
    public void testGetMarket() throws ExchangeException {
        Market zetMarket = api.getMarket("zet", "btc");
        assertNotNull(zetMarket);
    }

    @Test
    public void testGetMarketData() throws ExchangeException {
        Market zetMarket = api.getMarket("zet", "btc");
        MarketData zetMarketData = api.getMarketData(zetMarket.getId());
        assertNotNull(zetMarketData);
    }

    @Test
    @Ignore
    public void testGetOrderBook() throws ExchangeException {
        Market zetMarket = api.getMarket("zet", "btc");
        OrderBook zetOrderBook = api.getOrderBook(zetMarket.getId());
        assertNotNull(zetOrderBook);
    }

    @Test
    public void testGetLastTrades() throws ExchangeException {
        Market zetMarket = api.getMarket("zet", "btc");
        List<Trade> zetLastTrades = api.getLastTrades(zetMarket.getId());
        assertNotNull(!zetLastTrades.isEmpty());
    }

}