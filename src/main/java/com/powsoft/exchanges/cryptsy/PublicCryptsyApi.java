package com.powsoft.exchanges.cryptsy;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.powsoft.exchanges.ExchangeException;
import com.powsoft.exchanges.PublicExchangeApi;
import com.powsoft.exchanges.cryptsy.request.MarketDataV2Request;
import com.powsoft.exchanges.cryptsy.request.SingleMarketDataRequest;
import com.powsoft.exchanges.cryptsy.response.MarketDataV2Response;
import com.powsoft.exchanges.cryptsy.response.SingleMarketDataResponse;
import com.powsoft.exchanges.model.*;
import com.powsoft.exchanges.utils.WebUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An implementation of the Cryptsy public API
 * @author opsun
 * @since 1.0, 2014-6-5
 */
public class PublicCryptsyApi extends AbstractCryptsyApi implements PublicExchangeApi {
    private final static String PUB_API = "http://pubapi.cryptsy.com/api.php";

    private ObjectMapper objectMapper = new ObjectMapper();

    private List<Market> markets;

    @Override
    protected JsonNode query(String method, Map<String, String> params) throws IOException {
        Map<String, String> map = new HashMap<String, String>();
        if (params != null) {
            map.putAll(params);
        }
        map.put("method", method);
        return objectMapper.readTree(WebUtils.doGet(PUB_API, map, ExchangeEnum.CRYPTSY));
    }

    @Override
    public ExchangeEnum getExchange() throws ExchangeException {
        return ExchangeEnum.CRYPTSY;
    }

    @Override
    public List<Market> getExchangeMarkets() throws ExchangeException {
        try {
            List<Market> markets = new ArrayList<Market>();
            MarketDataV2Response response = execute(new MarketDataV2Request());
            for (String marketKey : response.getMarketData().keySet()) {
                com.powsoft.exchanges.cryptsy.vo.MarketData md = response.getMarketData().get(marketKey);
                Market m = new Market();
                m.setId("" + md.getMarketId());
                m.setExchange(ExchangeEnum.CRYPTSY);
                m.setPrimaryCurrency(md.getPrimaryCode());
                m.setPrimaryCurrencyLong(md.getPrimaryName());
                m.setSecondaryCurrency(md.getSecondaryCode());
                m.setSecondaryCurrencyLong(md.getSecondaryName());
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
            SingleMarketDataRequest request = new SingleMarketDataRequest();
            request.setMarketId(new Integer(marketId));

            SingleMarketDataResponse response = execute(request);

            MarketData marketData = new MarketData();

            marketData.setLast(response.getLastTradePrice());
            marketData.setName(response.getLabel());
            marketData.setVolume(response.getVolume());

            return marketData;

        } catch (ApiException e) {
            throw new ExchangeException(e);
        } catch (IOException e) {
            throw new ExchangeException(e);
        }
    }

    @Override
    public OrderBook getOrderBook(String marketId) throws ExchangeException {
        try {
            OrderBook orderBook = new OrderBook();
            MarketDataV2Response response = execute(new MarketDataV2Request());
            for (String marketKey : response.getMarketData().keySet()) {
                com.powsoft.exchanges.cryptsy.vo.MarketData md = response.getMarketData().get(marketKey);

                if (("" + md.getMarketId()).equalsIgnoreCase(marketId)) {

                    List<Order> buyOrders = new ArrayList<Order>();
                    List<Order> sellOrders = new ArrayList<Order>();
                    List<com.powsoft.exchanges.cryptsy.vo.Order> voBuyOrders = md.getBuyOrders();
                    List<com.powsoft.exchanges.cryptsy.vo.Order> voSellOrders = md.getSellOrders();

                    for (com.powsoft.exchanges.cryptsy.vo.Order o : voBuyOrders) {
                        Order order = new Order();
                        order.setOrderType(OrderTypeEnum.BUY);
                        order.setPrice(o.getPrice());
                        order.setQuantity(o.getQuantity());
                        order.setTotal(o.getTotal());
                        buyOrders.add(order);
                    }
                    orderBook.setBuyOrders(buyOrders);

                    for (com.powsoft.exchanges.cryptsy.vo.Order o : voSellOrders) {
                        Order order = new Order();
                        order.setOrderType(OrderTypeEnum.SELL);
                        order.setPrice(o.getPrice());
                        order.setQuantity(o.getQuantity());
                        order.setTotal(o.getTotal());
                        sellOrders.add(order);
                    }
                    orderBook.setSellOrders(sellOrders);
                    break;
                }
            }

            return orderBook;

        } catch (ApiException e) {
            throw new ExchangeException(e);
        } catch (IOException e) {
            throw new ExchangeException(e);
        }
    }

    @Override
    public List<Trade> getLastTrades(String marketId) throws ExchangeException {
        try {
            List<Trade> trades = new ArrayList<Trade>();
            MarketDataV2Response response = execute(new MarketDataV2Request());
            for (String marketKey : response.getMarketData().keySet()) {
                com.powsoft.exchanges.cryptsy.vo.MarketData md = response.getMarketData().get(marketKey);

                if (("" + md.getMarketId()).equalsIgnoreCase(marketId)) {

                    for (com.powsoft.exchanges.cryptsy.vo.TradeOrder t : md.getRecentTrades()) {
                        Trade trade = new Trade();
                        trade.setTotal(t.getTotal());
                        trade.setQuantity(t.getQuantity());
                        trade.setPrice(t.getPrice());
                        trade.setId("" + t.getId());
                        trade.setType(OrderTypeEnum.valueOf(t.getType().toUpperCase()));
                        trades.add(trade);
                    }

                    break;
                }
            }

            return trades;

        } catch (ApiException e) {
            throw new ExchangeException(e);
        } catch (IOException e) {
            throw new ExchangeException(e);
        }
    }
}
