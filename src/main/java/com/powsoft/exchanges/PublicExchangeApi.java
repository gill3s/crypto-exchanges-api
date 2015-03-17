package com.powsoft.exchanges;

import com.powsoft.exchanges.model.*;

import java.util.List;

/**
 * @author Gilles Caidignan
 */
public interface PublicExchangeApi {
    /**
     * Returns exchange name
     *
     * @return exchangeEnum corresponding to the exchange
     */
    public ExchangeEnum getExchange() throws ExchangeException;

    // PUBLIC API CALLS

    /**
     * Returns the list of all available markets on this exchange
     *
     * @return a list of markets
     * @throws ExchangeException
     */
    public List<Market> getExchangeMarkets() throws ExchangeException;

    /**
     * Return a specific market of the exchange
     *
     * @param primaryCurrency
     * @param secondaryCurrency
     * @return the target market
     * @throws ExchangeException
     */
    public Market getMarket(String primaryCurrency, String secondaryCurrency) throws ExchangeException;

    /**
     * Returns market data for a given market id
     *
     * @param marketId : the market id
     * @return market data
     * @throws ExchangeException
     */
    public MarketData getMarketData(String marketId) throws ExchangeException;

    /**
     * Returns the order book of a given marlet
     *
     * @param marketId: the id of the target market
     * @return the list of orders contained in the order book
     * @throws ExchangeException
     */
    public OrderBook getOrderBook(String marketId) throws ExchangeException;

    /**
     * Return the last trades of a given market
     *
     * @param marketId
     * @return the list of the last trades of the target market
     * @throws ExchangeException
     */
    public List<Trade> getLastTrades(String marketId) throws ExchangeException;

}
