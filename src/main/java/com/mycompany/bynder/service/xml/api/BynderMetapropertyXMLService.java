package com.mycompany.bynder.service.xml.api;

import com.mycompany.bynder.domain.metaproperty.BynderMetapropertyCollection;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

public interface BynderMetapropertyXMLService extends BynderXMLService<BynderMetapropertyCollection>{
    File toXMLFile(String fileName, BynderMetapropertyCollection assetCollection) throws JAXBException, IOException;

    String toXMLString(BynderMetapropertyCollection assetCollection) throws JAXBException;

    BynderMetapropertyCollection fromXMLFile(File xmlFile) throws JAXBException;
}
