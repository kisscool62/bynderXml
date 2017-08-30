package com.mycompany.bynder;

import com.bynder.sdk.service.BynderService;
import com.mycompany.bynder.domain.media.BynderMedias;
import com.mycompany.bynder.service.bynder.BynderAssetService;
import com.mycompany.bynder.service.bynder.BynderMediaService;
import com.mycompany.bynder.service.bynder.media.BynderMediaServiceFactory;
import com.mycompany.bynder.service.bynder.BynderServiceFactory;
import com.mycompany.bynder.service.xml.BynderMediaXMLServiceImpl;
import com.mycompany.bynder.service.xml.BynderXMLService;

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
        BynderMedias bynderMedias = mediaService.synchronousQuery();
        BynderXMLService bynderXMLService = new BynderMediaXMLServiceImpl();
        File xmlFile = bynderXMLService.toXMLFile("xmlFile.xml", bynderMedias);

    }
}
