package com.mycompany.bynder.service.bynder.metaproperty;

import com.bynder.sdk.service.BynderService;
import com.mycompany.bynder.domain.metaproperty.BynderMetapropertyCollection;
import com.mycompany.bynder.service.bynder.BynderAssetService;

public class BynderMetapropertyServiceFactory {

    private BynderMetapropertyServiceFactory() {}

    public static BynderAssetService<BynderMetapropertyCollection> create(BynderService bynderService){
        return new BynderMetapropertyServiceImpl(bynderService);
    }
}
