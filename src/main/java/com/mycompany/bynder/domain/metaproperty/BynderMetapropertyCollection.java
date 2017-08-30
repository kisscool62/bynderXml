package com.mycompany.bynder.domain.metaproperty;

import com.mycompany.bynder.domain.BynderAssetCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;

import static com.mycompany.bynder.domain.metaproperty.BynderMetapropertyCollection.ROOT_NAME;


@XmlRootElement(name=ROOT_NAME)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BynderMetapropertyCollection implements BynderAssetCollection {
    public static final String ROOT_NAME = "bynderMetaproperties";

    private Map<String, BynderMetaproperty> bynderMetapropertyMap;
}
