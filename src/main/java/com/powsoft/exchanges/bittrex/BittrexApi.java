package com.powsoft.exchanges.bittrex;

import java.io.IOException;


/**
 * @author opsun
 * @since 1.0, 2014-6-5
 */
public interface BittrexApi {

    /**
     * call cryptsy.com api
     *
     * @param request
     * @return
     * @throws ApiException
     * @throws java.io.IOException
     */
    public <T extends Object> T execute(BittrexRequest<T> request) throws ApiException, IOException;

}
