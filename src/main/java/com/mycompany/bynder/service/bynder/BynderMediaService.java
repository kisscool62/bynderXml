package com.mycompany.bynder.service.bynder;

import com.mycompany.bynder.domain.media.BynderMediaCollection;

public interface BynderMediaService extends BynderAssetService<BynderMediaCollection> {

    BynderMediaCollection synchronousQuery() throws IllegalAccessException;
}

