package com.mycompany.bynder.service.bynder;

import com.mycompany.bynder.domain.metaproperty.BynderMetapropertyCollection;

public interface BynderMetapropertyService extends BynderAssetService<BynderMetapropertyCollection> {

    BynderMetapropertyCollection getAll() throws IllegalAccessException;
}

