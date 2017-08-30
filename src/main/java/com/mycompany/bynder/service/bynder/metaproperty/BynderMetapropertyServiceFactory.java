package com.mycompany.bynder.service.bynder.metaproperty;

import com.bynder.sdk.service.BynderService;
import com.mycompany.bynder.domain.metaproperty.BynderMetaproperties;
import com.mycompany.bynder.service.bynder.BynderAssetService;

public class BynderMetapropertyServiceFactory {
    public static BynderAssetService<BynderMetaproperties> create(BynderService bynderService){
        return new BynderMetapropertyServiceImpl(bynderService);
    }
}
