package com.mycompany.bynder.service.bynder;

import com.mycompany.bynder.domain.BynderAssetCollection;
import com.mycompany.bynder.domain.media.BynderMedias;
import com.mycompany.bynder.domain.metaproperty.BynderMetaproperties;

public interface BynderAssetService<T extends BynderAssetCollection> {

    T synchronousQuery() throws IllegalAccessException;
}

