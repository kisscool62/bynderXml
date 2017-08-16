package com.mycompany.bynder.service.xml;

import com.mycompany.bynder.domain.BynderAssetCollection;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;

public interface BynderXMLService <AssetCollection extends BynderAssetCollection>{
    File toXMLFile(String fileName, AssetCollection assetCollection) throws JAXBException, FileNotFoundException;

    String toXMLString(AssetCollection assetCollection) throws JAXBException;
}
