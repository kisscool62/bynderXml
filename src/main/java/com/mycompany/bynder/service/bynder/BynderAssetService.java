package com.mycompany.bynder.service.bynder;

import com.mycompany.bynder.domain.BynderAssetCollection;
import com.mycompany.bynder.domain.media.BynderMedias;
import com.mycompany.bynder.domain.metaproperty.BynderMetaproperties;

public interface BynderAssetService<AssetCollection extends BynderAssetCollection> {

    AssetCollection synchronousQuery() throws IllegalAccessException;
}

