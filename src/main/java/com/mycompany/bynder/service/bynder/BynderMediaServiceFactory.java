package com.mycompany.bynder.service.bynder;

import com.bynder.sdk.service.BynderService;

public class BynderMediaServiceFactory {
    public static BynderMediaService create(BynderService bynderService){
        return new BynderMediaServiceImpl(bynderService);
    }
}
