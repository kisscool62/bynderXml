package com.mycompany.bynder.service.bynder.metaproperty;

import com.bynder.sdk.service.BynderService;
import com.mycompany.bynder.service.bynder.BynderMetapropertyService;

public class BynderMetapropertyServiceFactory {

    private BynderMetapropertyServiceFactory() {}

    public static BynderMetapropertyService create(BynderService bynderService){
        return new BynderMetapropertyServiceImpl(bynderService);
    }
}
