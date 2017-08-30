package com.mycompany.bynder;

import com.bynder.sdk.service.BynderService;
import com.mycompany.bynder.domain.media.BynderMediaCollection;
import com.mycompany.bynder.domain.metaproperty.BynderMetapropertyCollection;
import com.mycompany.bynder.service.bynder.BynderMediaService;
import com.mycompany.bynder.service.bynder.BynderMetapropertyService;
import com.mycompany.bynder.service.bynder.BynderServiceFactory;
import com.mycompany.bynder.service.bynder.media.BynderMediaServiceFactory;
import com.mycompany.bynder.service.bynder.metaproperty.BynderMetapropertyServiceFactory;
import com.mycompany.bynder.service.xml.api.BynderMediaXMLService;
import com.mycompany.bynder.service.xml.api.BynderMetapropertyXMLService;
import com.mycompany.bynder.service.xml.impl.BynderMediaXMLServiceImpl;
import com.mycompany.bynder.service.xml.api.BynderXMLService;
import com.mycompany.bynder.service.xml.impl.BynderMetaPropertyXMLServiceImpl;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IllegalAccessException, IOException, JAXBException {

        BynderService service = BynderServiceFactory.create("https:\\plugin.getbynder.com/api/v4/",
                "",
                "",
                "",
                ""
        );

        BynderMediaService mediaService = BynderMediaServiceFactory.create(service);
        BynderMediaCollection bynderMediaCollection = mediaService.getAll();
        BynderXMLService bynderMediaXMLService = new BynderMediaXMLServiceImpl();
        bynderMediaXMLService.toXMLFile("xmlMedia.xml", bynderMediaCollection);

        BynderMetapropertyService metapropertyService = BynderMetapropertyServiceFactory.create(service);
        BynderMetapropertyCollection bynderMetapropertyCollection = metapropertyService.getAll();
        BynderMetapropertyXMLService bynderMetaXMLService = new BynderMetaPropertyXMLServiceImpl();
        bynderMetaXMLService.toXMLFile("xmlMetaProperty.xml", bynderMetapropertyCollection);

        bynderMetapropertyCollection = bynderMetaXMLService.fromXMLFile(new File("xmlMetaProperty.xml"));

        metapropertyService.post(bynderMetapropertyCollection);

    }
}
