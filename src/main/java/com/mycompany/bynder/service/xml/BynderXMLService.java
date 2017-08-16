package com.mycompany.bynder.service.xml;

import com.mycompany.bynder.domain.BynderAssetCollection;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;

public interface BynderXMLService <Asset extends BynderAssetCollection>{
    File toXMLFile(String fileName, Asset assetCollection) throws JAXBException, FileNotFoundException;

    String toXMLString(Asset assetCollection) throws JAXBException;
}
