package com.mycompany.bynder.service.bynder.media;

import com.bynder.sdk.service.BynderService;
import com.mycompany.bynder.domain.media.BynderMedias;
import com.mycompany.bynder.service.bynder.BynderAssetService;

public class BynderMediaServiceFactory {

    public static BynderMediaServiceImpl create(BynderService bynderService){
        return new BynderMediaServiceImpl(bynderService);
    }

}
