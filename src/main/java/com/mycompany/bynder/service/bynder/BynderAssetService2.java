package com.mycompany.bynder.service.bynder;

import com.mycompany.bynder.domain.BynderAssetCollection;
import com.mycompany.bynder.domain.metaproperty.BynderMetaproperties;

public interface BynderAssetService2<AssetCollection extends BynderAssetCollection> {

    BynderMetaproperties synchronousQuery() throws IllegalAccessException;

}
