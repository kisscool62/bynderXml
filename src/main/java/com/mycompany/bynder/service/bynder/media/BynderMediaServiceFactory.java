package com.mycompany.bynder.service.bynder.media;

import com.bynder.sdk.service.BynderService;
import com.mycompany.bynder.service.bynder.BynderMediaService;

public class BynderMediaServiceFactory {

    private BynderMediaServiceFactory() {}

    public static BynderMediaService create(BynderService bynderService){
        return new BynderMediaServiceImpl(bynderService);
    }
}
