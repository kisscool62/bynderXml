package com.mycompany.bynder;

import com.bynder.sdk.model.Media;
import com.mycompany.bynder.domain.BinderMedia;
import com.mycompany.bynder.service.bynder.BynderMediaService;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import static com.mycompany.bynder.DomainUtils.newXMLMedia;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class XMLWriterServiceTest {

    @Test
    public void shouldWriteFromMedia() throws IllegalAccessException, JAXBException {
        //given
        BynderMediaService mockBynderMediaService = mock(BynderMediaService.class);

        List<BinderMedia> dummyList = new ArrayList<BinderMedia>(2);
        dummyList.add(newXMLMedia("first one"));
        dummyList.add(newXMLMedia("second one"));

        when(mockBynderMediaService.synchronousQuery()).thenReturn(dummyList);

        //when
        StringWriter stringWriter = new StringWriter();
        JAXBContext jaxbContext = JAXBContext.newInstance(Media.class);

        JAXBElement<Media> jaxbElement = new JAXBElement<Media>(
                new QName("media"),
                Media.class,
                Media.class,
                dummyList.get(0).getMedia());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(jaxbElement, stringWriter);

        //then
        System.out.println(stringWriter.toString());


    }
}
