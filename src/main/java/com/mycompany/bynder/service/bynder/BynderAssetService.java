package com.mycompany.bynder.service.bynder;

import com.mycompany.bynder.domain.BynderAssetCollection;

public interface BynderAssetService<T extends BynderAssetCollection> {

    T synchronousQuery() throws IllegalAccessException;
}

