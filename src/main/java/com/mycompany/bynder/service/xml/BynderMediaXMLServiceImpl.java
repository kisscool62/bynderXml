package com.mycompany.bynder.service.xml;

import com.mycompany.bynder.domain.media.BynderMedias;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

import static javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT;

public class BynderMediaXMLServiceImpl implements BynderXMLService<BynderMedias>{

    private static final String ROOT_NAME = "bynderMedias";

    private class MediaOutputResolver extends SchemaOutputResolver{
        @Override
        public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
            File file = new File(suggestedFileName);
            StreamResult result = new StreamResult(file);
            result.setSystemId(file.toURI().toURL().toString());
            return result;
        }
    }

    public File toXMLFile(String fileName, BynderMedias bynderMedias) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(BynderMedias.class);
        jaxbContext.generateSchema(new MediaOutputResolver());
        JAXBElement<BynderMedias> jaxbElement = new JAXBElement<BynderMedias>(
                new QName(ROOT_NAME),
                BynderMedias.class,
                bynderMedias);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(JAXB_FORMATTED_OUTPUT, true);

        File xmlFile = new File(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(xmlFile);
        jaxbMarshaller.marshal(jaxbElement, fileOutputStream);
        return xmlFile;
    }


    public String toXMLString(BynderMedias bynderMedias) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(BynderMedias.class);

        JAXBElement<BynderMedias> jaxbElement = new JAXBElement<BynderMedias>(
                new QName(ROOT_NAME),
                BynderMedias.class,
                bynderMedias);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(JAXB_FORMATTED_OUTPUT, true);
        StringWriter stringWriter = new StringWriter();
        jaxbMarshaller.marshal(jaxbElement, stringWriter);
        return stringWriter.toString();
    }
}
