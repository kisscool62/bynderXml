package com.mycompany.bynder.service.bynder.metaproperty;

import com.bynder.sdk.model.Metaproperty;
import com.bynder.sdk.query.MetapropertyQuery;
import com.bynder.sdk.service.AssetBankService;
import com.bynder.sdk.service.BynderService;
import com.mycompany.bynder.domain.metaproperty.BynderMetaproperty;
import com.mycompany.bynder.domain.metaproperty.BynderMetapropertyCollection;
import com.mycompany.bynder.service.bynder.BynderAssetService;
import retrofit2.Response;

import java.util.HashMap;
import java.util.Map;

import static com.bynder.sdk.model.MediaType.IMAGE;

public class BynderMetapropertyServiceImpl implements BynderAssetService<BynderMetapropertyCollection> {

    private final BynderService bynderService;

    BynderMetapropertyServiceImpl(BynderService bynderService) {
        this.bynderService = bynderService;
    }

    public BynderMetapropertyCollection synchronousQuery() throws IllegalAccessException {
        // Get an instance of the asset bank service to perform Bynder Asset Bank operations.
        AssetBankService assetBankService = bynderService.getAssetBankService();

        // Get metaproperty (request with query)
        Response<Map<String, Metaproperty>> metapropertyResponse =
                assetBankService.getMetaproperties(
                        new MetapropertyQuery()
                                .setType(IMAGE))
                        .blockingSingle();

        return new BynderMetapropertyCollection(
                collect(metapropertyResponse));

    }

    private Map<String, BynderMetaproperty> collect(Response<Map<String, Metaproperty>> mediaResponse) {

        Map<String, BynderMetaproperty> bynderMetapropertyMap = new HashMap<String, BynderMetaproperty>();
        for (Map.Entry<String, Metaproperty> entry : mediaResponse.body().entrySet()) {
            bynderMetapropertyMap.put(entry.getKey(),BynderMetaproperty.create(entry.getValue()));
        }

        return bynderMetapropertyMap;
    }


}
