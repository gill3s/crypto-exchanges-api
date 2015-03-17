package com.powsoft.exchanges.bittrex;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.powsoft.exchanges.ExchangeException;
import com.powsoft.exchanges.PublicExchangeApi;
import com.powsoft.exchanges.bittrex.request.GetMarketHistoryRequest;
import com.powsoft.exchanges.bittrex.request.GetMarketSummaryRequest;
import com.powsoft.exchanges.bittrex.request.GetMarketsRequest;
import com.powsoft.exchanges.bittrex.response.GetMarketHistoryResponse;
import com.powsoft.exchanges.bittrex.response.GetMarketSummaryResponse;
import com.powsoft.exchanges.bittrex.response.GetMarketsResponse;
import com.powsoft.exchanges.model.*;
import com.powsoft.exchanges.utils.WebUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An implementation of the Cryptsy public API
 *
 * @author opsun
 * @since 1.0, 2014-6-5
 */
public class PublicBittrexApi extends AbstractBittrexApi implements PublicExchangeApi {
    private final static String PUB_API = "https://bittrex.com/api/v1.1/public/";

    private ObjectMapper objectMapper = new ObjectMapper();

    private List<Market> markets;

    @Override
    protected JsonNode query(String method, Map<String, String> params) throws IOException {
        Map<String, String> map = new HashMap<String, String>();
        if (params != null) {
            map.putAll(params);
        }

        return objectMapper.readTree(WebUtils.doGet(PUB_API + method, map, ExchangeEnum.BITTREX));
    }

    @Override
    public ExchangeEnum getExchange() throws ExchangeException {
        return ExchangeEnum.BITTREX;
    }

    @Override
    public List<Market> getExchangeMarkets() throws ExchangeException {
        try {
            List<Market> markets = new ArrayList<Market>();
            GetMarketsResponse response = execute(new GetMarketsRequest());
            for (com.powsoft.exchanges.bittrex.vo.Market market : response.getMarkets()) {
                Market m = new Market();
                m.setId(market.getMarketName());
                m.setExchange(ExchangeEnum.CRYPTSY);
                m.setPrimaryCurrency(market.getMarketCurrency());
                m.setPrimaryCurrencyLong(market.getMarketCurrencyLong());
                m.setSecondaryCurrency(market.getBaseCurrency());
                m.setSecondaryCurrencyLong(market.getBaseCurrencyLong());
                markets.add(m);
            }
            this.markets = markets;
            return markets;
        } catch (ApiException e) {
            throw new ExchangeException(e);
        } catch (IOException e) {
            throw new ExchangeException(e);
        }
    }

    @Override
    public Market getMarket(String primaryCurrency, String secondaryCurrency) throws ExchangeException {
        if (this.markets == null) {
            this.markets = getExchangeMarkets();
        }

        Market targetMarket = null;
        for (Market m : markets) {
            if (m.getPrimaryCurrency().equalsIgnoreCase(primaryCurrency) &&
                    m.getSecondaryCurrency().equalsIgnoreCase(secondaryCurrency)) {
                targetMarket = m;
                break;
            }
        }
        return targetMarket;
    }

    @Override
    public MarketData getMarketData(String marketId) throws ExchangeException {
        try {
            GetMarketSummaryRequest request = new GetMarketSummaryRequest();
            request.setMarketId(marketId);

            GetMarketSummaryResponse response = execute(request);

            MarketData marketData = new MarketData();

            marketData.setLast(response.getMarketSummary().getLast());
            marketData.setName(response.getMarketSummary().getMarketName());
            marketData.setVolume(response.getMarketSummary().getVolume());

            return marketData;

        } catch (ApiException e) {
            throw new ExchangeException(e);
        } catch (IOException e) {
            throw new ExchangeException(e);
        }
    }

    @Override
    public OrderBook getOrderBook(String marketId) throws ExchangeException {
        /**try {
         OrderBook orderBook = new OrderBook();
         GetOrderBookRequest orderBookRequest = new GetOrderBookRequest();
         orderBookRequest.setMarketId(marketId);
         GetOrderBookResponse response = execute(orderBookRequest);
         List<Order> buyOrders = new ArrayList<Order>();
         List<Order> sellOrders = new ArrayList<Order>();

         for (com.powsoft.exchanges.bittrex.vo.Order o : response.getBuyOrders()) {
         Order order = new Order();
         order.setOrderType(OrderTypeEnum.BUY);
         order.setPrice(o.getRate());
         order.setQuantity(o.getQuantity());
         order.setTotal(o.getRate()*o.getQuantity());
         buyOrders.add(order);
         }
         orderBook.setBuyOrders(buyOrders);

         for (com.powsoft.exchanges.bittrex.vo.Order o : response.getSellOrders()) {
         Order order = new Order();
         order.setOrderType(OrderTypeEnum.SELL);
         order.setPrice(o.getRate());
         order.setQuantity(o.getQuantity());
         order.setTotal(o.getRate()*o.getQuantity());
         sellOrders.add(order);
         }

         return orderBook;

         } catch (ApiException e) {
         throw new ExchangeException(e);
         } catch (IOException e) {
         throw new ExchangeException(e);
         }**/
        throw new ExchangeException("Not yet supported");
    }

    @Override
    public List<Trade> getLastTrades(String marketId) throws ExchangeException {
        try {
            List<Trade> trades = new ArrayList<Trade>();
            GetMarketHistoryRequest marketHistoryRequest = new GetMarketHistoryRequest();
            marketHistoryRequest.setMarketId(marketId);
            GetMarketHistoryResponse response = execute(marketHistoryRequest);

            for (com.powsoft.exchanges.bittrex.vo.Trade t : response.getHistory()) {
                Trade trade = new Trade();
                trade.setTotal(t.getTotal());
                trade.setQuantity(t.getQuantity());
                trade.setPrice(t.getPrice());
                trade.setId(t.getId());
                trade.setType(OrderTypeEnum.valueOf(t.getOrderType().toUpperCase()));
                trades.add(trade);
            }

            return trades;

        } catch (ApiException e) {
            throw new ExchangeException(e);
        } catch (IOException e) {
            throw new ExchangeException(e);
        }
    }
}
