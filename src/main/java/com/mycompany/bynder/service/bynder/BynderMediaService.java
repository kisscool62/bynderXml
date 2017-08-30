package com.mycompany.bynder.service.bynder;

import com.mycompany.bynder.domain.media.BynderMedias;

public interface BynderMediaService extends BynderAssetService<BynderMedias> {

    BynderMedias synchronousQuery() throws IllegalAccessException;
}

