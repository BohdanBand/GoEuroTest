package com.goeuro.test.connector;


import com.goeuro.test.util.exception.CommunicationException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.core.impl.provider.entity.StringProvider;

import java.io.IOException;

public class RestDataConnector {

    public static final String URL_TEMPLATE = "http://api.goeuro.com/api/v2/position/suggest/en/";

    public String requestData(String location) throws CommunicationException, IOException {
        return callServer(URL_TEMPLATE + location);
    }

    public String requestData(String lat, String log) throws CommunicationException, IOException {
        return callServer(URL_TEMPLATE + lat + "/" + log);
    }

    private String callServer(String url) throws CommunicationException {

        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        clientConfig.getClasses().add(StringProvider.class);
        Client client = Client.create(clientConfig);

        WebResource webResource = client.resource(url);
        String contentType = "application/json";
        ClientResponse response = webResource.accept(contentType).get(ClientResponse.class);

        int successfulResponse = 200;
        if (response.getStatus() != successfulResponse) {
            throw new CommunicationException("Failed : HTTP error code : " + response.getStatus());
        }


        return response.getEntity(String.class);

    }
}