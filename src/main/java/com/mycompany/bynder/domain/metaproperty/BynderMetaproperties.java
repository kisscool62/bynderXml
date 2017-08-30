package com.mycompany.bynder.domain.metaproperty;

import com.mycompany.bynder.domain.BynderAssetCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;


@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BynderMetaproperties implements BynderAssetCollection {
    private Map<String, BynderMetaproperty> bynderMetapropertyMap;
}
