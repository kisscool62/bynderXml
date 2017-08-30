package com.mycompany.bynder.service.xml.api;

import com.mycompany.bynder.domain.media.BynderMediaCollection;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

public interface BynderMediaXMLService extends BynderXMLService<BynderMediaCollection>{
    File toXMLFile(String fileName, BynderMediaCollection assetCollection) throws JAXBException, IOException;

    String toXMLString(BynderMediaCollection assetCollection) throws JAXBException;

    BynderMediaCollection fromXMLFile(File xmlFile) throws JAXBException;
}
