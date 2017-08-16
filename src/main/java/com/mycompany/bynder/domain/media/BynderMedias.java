package com.mycompany.bynder.domain.media;

import com.mycompany.bynder.domain.BynderAssetCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BynderMedias implements BynderAssetCollection {
    private List<BynderMedia> bynderMedias;
}
