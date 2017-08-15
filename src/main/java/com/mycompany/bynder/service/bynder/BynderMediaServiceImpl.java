package com.mycompany.bynder.service.bynder;

import com.bynder.sdk.model.Media;
import com.bynder.sdk.model.MediaType;
import com.bynder.sdk.query.MediaQuery;
import com.bynder.sdk.service.AssetBankService;
import com.bynder.sdk.service.BynderService;
import retrofit2.Response;

import java.util.List;

/**
 * Created by pauregan for Serial Development. serial.ch
 */
public class BynderMediaServiceImpl implements BynderMediaService {

    private final BynderService bynderService;

    BynderMediaServiceImpl(BynderService bynderService) {
        this.bynderService = bynderService;
    }

    public List<Media> synchronousQuery() throws IllegalAccessException {
        // Get an instance of the asset bank service to perform Bynder Asset Bank operations.
        AssetBankService assetBankService = bynderService.getAssetBankService();

        // Get media (request with query)
        Response<List<Media>> mediaResponse =
                assetBankService.getMediaList(
                        new MediaQuery()
                                .setType(MediaType.IMAGE)
                                .setLimit(100)
                                .setPage(1))
                        .blockingSingle();

        return mediaResponse.body();
    }
}
