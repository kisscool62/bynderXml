package com.mycompany.bynder.service.xml;

import com.mycompany.bynder.domain.media.BynderMedias;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringWriter;

import static javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT;

public class BynderMediaXMLServiceImpl implements BynderXMLService<BynderMedias>{

    private static final String ROOT_NAME = "bynderMedias";

    @Override
    public File toXMLFile(String fileName, BynderMedias bynderMedias) throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(BynderMedias.class);

        JAXBElement<BynderMedias> jaxbElement = new JAXBElement<>(
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

    @Override
    public String toXMLString(BynderMedias bynderMedias) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(BynderMedias.class);

        JAXBElement<BynderMedias> jaxbElement = new JAXBElement<>(
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
