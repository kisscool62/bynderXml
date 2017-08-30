package com.mycompany.bynder.domain.metaproperty;

import com.mycompany.bynder.domain.BynderPayload;
import lombok.Getter;

@Getter
public class MetaPropertyPayLoad extends BynderPayload<BynderMetaproperty>{

    public MetaPropertyPayLoad(String url, BynderMetaproperty metaproperty) {
        super(url + metaproperty.getId(), metaproperty);
    }
}