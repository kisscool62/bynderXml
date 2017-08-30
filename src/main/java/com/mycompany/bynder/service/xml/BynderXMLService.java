package com.mycompany.bynder.service.xml;

import com.mycompany.bynder.domain.BynderAssetCollection;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

public interface BynderXMLService <T extends BynderAssetCollection>{
    File toXMLFile(String fileName, T assetCollection) throws JAXBException, IOException;

    String toXMLString(T assetCollection) throws JAXBException;
}
