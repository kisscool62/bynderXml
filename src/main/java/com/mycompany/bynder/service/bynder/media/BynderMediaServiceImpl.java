package com.mycompany.bynder.service.bynder.media;

import com.bynder.sdk.model.Media;
import com.bynder.sdk.model.Metaproperty;
import com.bynder.sdk.query.MediaQuery;
import com.bynder.sdk.service.AssetBankService;
import com.bynder.sdk.service.BynderService;
import com.mycompany.bynder.domain.media.BynderMedia;
import com.mycompany.bynder.domain.media.BynderMediaCollection;
import com.mycompany.bynder.domain.metaproperty.BynderMetaproperty;
import com.mycompany.bynder.domain.metaproperty.BynderMetapropertyCollection;
import com.mycompany.bynder.service.bynder.BynderMediaService;
import lombok.AllArgsConstructor;
import org.glassfish.jersey.client.oauth1.AccessToken;
import org.glassfish.jersey.client.oauth1.ConsumerCredentials;
import org.glassfish.jersey.client.oauth1.OAuth1ClientSupport;
import org.glassfish.jersey.jackson.JacksonFeature;
import retrofit2.Response;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Feature;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.bynder.sdk.model.MediaType.IMAGE;
import static javax.ws.rs.client.Entity.json;


public class BynderMediaServiceImpl implements BynderMediaService {

    private final BynderService bynderService;

    BynderMediaServiceImpl(BynderService bynderService) {
        this.bynderService = bynderService;
    }

    public BynderMediaCollection getAll() throws IllegalAccessException {
        // Get an instance of the asset bank service to perform Bynder Asset Bank operations.
        AssetBankService assetBankService = bynderService.getAssetBankService();

        // Get media (request with query)
        Response<List<Media>> mediaResponse =
                assetBankService.getMediaList(
                        new MediaQuery()
                                .setType(IMAGE)
                                .setLimit(100)
                                .setPage(1))
                        .blockingSingle();

        return new BynderMediaCollection(
                collect(mediaResponse));

    }


    private List<BynderMedia> collect(Response<List<Media>> mediaResponse) {

        List<BynderMedia> bynderMediaList = new ArrayList<BynderMedia>();
        for (Media media : mediaResponse.body()){
            bynderMediaList.add(BynderMedia.create(media));
        }
        return bynderMediaList;
    }


}
