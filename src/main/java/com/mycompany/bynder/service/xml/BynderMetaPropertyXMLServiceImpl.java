package com.mycompany.bynder.service.xml;

import com.mycompany.bynder.domain.metaproperty.BynderMetapropertyCollection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.namespace.QName;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

import static com.mycompany.bynder.domain.metaproperty.BynderMetapropertyCollection.ROOT_NAME;
import static javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT;

public class BynderMetaPropertyXMLServiceImpl implements BynderXMLService<BynderMetapropertyCollection>{

    private class MediaOutputResolver extends SchemaOutputResolver{
        @Override
        public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
            File file = new File(suggestedFileName);
            StreamResult result = new StreamResult(file);
            result.setSystemId(file.toURI().toURL().toString());
            return result;
        }
    }

    public File toXMLFile(String fileName, BynderMetapropertyCollection bynderMetapropertyCollection) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(BynderMetapropertyCollection.class);
        jaxbContext.generateSchema(new MediaOutputResolver());
        JAXBElement<BynderMetapropertyCollection> jaxbElement = new JAXBElement<BynderMetapropertyCollection>(
                new QName(ROOT_NAME),
                BynderMetapropertyCollection.class,
                bynderMetapropertyCollection);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(JAXB_FORMATTED_OUTPUT, true);

        File xmlFile = new File(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(xmlFile);
        jaxbMarshaller.marshal(jaxbElement, fileOutputStream);
        return xmlFile;
    }


    public String toXMLString(BynderMetapropertyCollection bynderMetapropertyCollection) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(BynderMetapropertyCollection.class);

        JAXBElement<BynderMetapropertyCollection> jaxbElement = new JAXBElement<BynderMetapropertyCollection>(
                new QName(ROOT_NAME),
                BynderMetapropertyCollection.class,
                bynderMetapropertyCollection);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(JAXB_FORMATTED_OUTPUT, true);
        StringWriter stringWriter = new StringWriter();
        jaxbMarshaller.marshal(jaxbElement, stringWriter);
        return stringWriter.toString();
    }
}
