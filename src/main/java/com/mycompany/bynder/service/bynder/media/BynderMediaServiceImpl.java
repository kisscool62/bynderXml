package com.mycompany.bynder.service.bynder.media;

import com.bynder.sdk.model.Media;
import com.bynder.sdk.query.MediaQuery;
import com.bynder.sdk.service.AssetBankService;
import com.bynder.sdk.service.BynderService;
import com.mycompany.bynder.domain.media.BynderMedia;
import com.mycompany.bynder.domain.media.BynderMediaCollection;
import com.mycompany.bynder.service.bynder.BynderMediaService;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

import static com.bynder.sdk.model.MediaType.IMAGE;

public class BynderMediaServiceImpl implements BynderMediaService {

    private final BynderService bynderService;

    BynderMediaServiceImpl(BynderService bynderService) {
        this.bynderService = bynderService;
    }

    public BynderMediaCollection synchronousQuery() throws IllegalAccessException {
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