package com.mycompany.bynder.domain.media;

import com.mycompany.bynder.domain.BynderAssetCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

import static com.mycompany.bynder.domain.media.BynderMediaCollection.ROOT_NAME;


@XmlRootElement(name = ROOT_NAME)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BynderMediaCollection implements BynderAssetCollection {
    public static final String ROOT_NAME = "bynderMedias";

    private List<BynderMedia> bynderMedias;
}
