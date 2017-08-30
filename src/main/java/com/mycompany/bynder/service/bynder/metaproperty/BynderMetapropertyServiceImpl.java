package com.mycompany.bynder.service.bynder.metaproperty;

import com.bynder.sdk.model.Metaproperty;
import com.bynder.sdk.query.MetapropertyQuery;
import com.bynder.sdk.service.AssetBankService;
import com.bynder.sdk.service.BynderService;
import com.mycompany.bynder.domain.metaproperty.BynderMetaproperty;
import com.mycompany.bynder.domain.metaproperty.BynderMetapropertyCollection;
import com.mycompany.bynder.domain.metaproperty.MetaPropertyPayLoad;
import com.mycompany.bynder.service.bynder.BynderMetapropertyService;
import org.glassfish.jersey.client.oauth1.AccessToken;
import org.glassfish.jersey.client.oauth1.ConsumerCredentials;
import org.glassfish.jersey.client.oauth1.OAuth1ClientSupport;
import org.glassfish.jersey.jackson.JacksonFeature;
import retrofit2.Response;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Feature;
import java.util.HashMap;
import java.util.Map;

import static com.bynder.sdk.model.MediaType.IMAGE;

public class BynderMetapropertyServiceImpl implements BynderMetapropertyService {

    private final BynderService bynderService;
    private String URL_BASE = "https://plugin.getbynder.com/api/v4/metaproperties/"; //todo set as property

    BynderMetapropertyServiceImpl(BynderService bynderService) {
        this.bynderService = bynderService;
    }

    public BynderMetapropertyCollection getAll() throws IllegalAccessException {
        // Get an instance of the asset bank service to perform Bynder Asset Bank operations.
        AssetBankService assetBankService = bynderService.getAssetBankService();

        // Get metaproperty (request with query)
        Response<Map<String, Metaproperty>> metapropertyResponse =
                assetBankService.getMetaproperties(
                        new MetapropertyQuery()
                                .setType(IMAGE))
                        .blockingSingle();

        return new BynderMetapropertyCollection(
                collect(metapropertyResponse));

    }

    private Map<String, BynderMetaproperty> collect(Response<Map<String, Metaproperty>> mediaResponse) {

        Map<String, BynderMetaproperty> bynderMetapropertyMap = new HashMap<String, BynderMetaproperty>();
        for (Map.Entry<String, Metaproperty> entry : mediaResponse.body().entrySet()) {
            bynderMetapropertyMap.put(entry.getKey(),BynderMetaproperty.create(entry.getValue()));
        }

        return bynderMetapropertyMap;
    }

    public void post(BynderMetapropertyCollection metapropertyCollection) throws IllegalAccessException {
        String PROPERTY_TOKEN = "";
        byte[] PROPERTY_TOKEN_SECRET = {};
        String PROPERTY_CONSUMER_KEY = "";
        byte[] PROPERTY_CONSUMER_SECRET = {};
        final AccessToken storedToken = new AccessToken(PROPERTY_TOKEN, PROPERTY_TOKEN_SECRET);
        final ConsumerCredentials consumerCredentials = new ConsumerCredentials(
                PROPERTY_CONSUMER_KEY,
                PROPERTY_CONSUMER_SECRET);

        // build a new feature from the stored consumer credentials and access token
        final Feature filterFeature = OAuth1ClientSupport.builder(consumerCredentials).feature()
                .accessToken(storedToken).build();


        final Client client = ClientBuilder.newBuilder()
                .register(filterFeature)
                .register(JacksonFeature.class)
                .build();

        for (Map.Entry<String, BynderMetaproperty> metapropertyEntry : metapropertyCollection.getBynderMetapropertyMap().entrySet()) {

            post(client, metapropertyEntry.getValue());
        }

    }

    private void post(Client client, BynderMetaproperty metaproperty) {
        MetaPropertyPayLoad metaPropertyPayLoad = new MetaPropertyPayLoad(URL_BASE, metaproperty);
        javax.ws.rs.core.Response response = client
                                                .target(metaPropertyPayLoad.getUrl())
                                                .request()
                                                .post(metaPropertyPayLoad.getPayload());

        handlePostResponse(response);

    }

    private void handlePostResponse(javax.ws.rs.core.Response response) {
        switch (response.getStatus()){
            case 201:
                // log success
                break;
            case 400:
                // log Invalid type
                break;
            case 404:
                // log not found error
                break;
            default:
                //log stuff
                break;
        }
    }



}
