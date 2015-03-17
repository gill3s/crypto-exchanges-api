/*
 * Copyright (c) 2015 Pow-Soft (http://www.pow-soft.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.powsoft.exchanges.model;

/**
 * @author Gilles Caidignan
 *         Represent an exchange market
 */
public class Market {
    // Exchange
    private ExchangeEnum exchange;
    // Market id used on exchange
    private String id;
    // Primary currency code (ex: BTC)
    private String primaryCurrency;
    // Primary currency long name (ex: Bitcoin)
    private String primaryCurrencyLong;
    // Secondary currency code (ex: LTC)
    private String secondaryCurrency;
    // Secondary currency long name (ex: Litecion)
    private String secondaryCurrencyLong;

    public ExchangeEnum getExchange() {
        return exchange;
    }

    public void setExchange(ExchangeEnum exchange) {
        this.exchange = exchange;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrimaryCurrency() {
        return primaryCurrency;
    }

    public void setPrimaryCurrency(String primaryCurrency) {
        this.primaryCurrency = primaryCurrency;
    }

    public String getPrimaryCurrencyLong() {
        return primaryCurrencyLong;
    }

    public void setPrimaryCurrencyLong(String primaryCurrencyLong) {
        this.primaryCurrencyLong = primaryCurrencyLong;
    }

    public String getSecondaryCurrency() {
        return secondaryCurrency;
    }

    public void setSecondaryCurrency(String secondaryCurrency) {
        this.secondaryCurrency = secondaryCurrency;
    }

    public String getSecondaryCurrencyLong() {
        return secondaryCurrencyLong;
    }

    public void setSecondaryCurrencyLong(String secondaryCurrencyLong) {
        this.secondaryCurrencyLong = secondaryCurrencyLong;
    }
}
