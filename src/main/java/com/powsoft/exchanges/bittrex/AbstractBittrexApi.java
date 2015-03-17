package com.powsoft.exchanges.bittrex;

import com.fasterxml.jackson.databind.JsonNode;
import com.powsoft.exchanges.utils.Assert;

import java.io.IOException;
import java.util.Map;

public abstract class AbstractBittrexApi implements BittrexApi {

    /**
     * to encapsulate the query data and request API<br>
     * Public API and Authenticated API have different implementation<br>
     *
     * @param method
     * @param params
     * @return
     * @throws java.io.IOException
     */
    protected abstract JsonNode query(String method, Map<String, String> params) throws IOException;

    @Override
    public <T extends Object> T execute(BittrexRequest<T> request) throws ApiException, IOException {
        if (request == null) {
            throw new NullPointerException();
        }

        if (Assert.isEmpty(request.getMethod())) {
            throw new ApiException("method is required");
        }

        JsonNode json = query(request.getMethod(), request.getParams());
        boolean success = json.get("success").asBoolean();
        if (!success) {
            throw new ApiException(json.get("message").asText());
        }

        return request.parse(json.has("result") ? json.get("result") : json);
    }
}
