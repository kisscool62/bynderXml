package com.mycompany.bynder.service.xml;

import com.mycompany.bynder.domain.BynderAssetCollection;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface BynderXMLService <AssetCollection extends BynderAssetCollection>{
    File toXMLFile(String fileName, AssetCollection assetCollection) throws JAXBException, IOException;

    String toXMLString(AssetCollection assetCollection) throws JAXBException;
}
