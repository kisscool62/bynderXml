package com.mycompany.bynder;

import com.mycompany.bynder.domain.media.BynderMedia;
import com.mycompany.bynder.domain.media.BynderMediaCollection;
import com.mycompany.bynder.domain.metaproperty.BynderMetaproperty;
import com.mycompany.bynder.domain.metaproperty.BynderMetapropertyCollection;
import com.mycompany.bynder.service.bynder.BynderAssetService;
import com.mycompany.bynder.service.xml.BynderMediaXMLServiceImpl;
import com.mycompany.bynder.service.xml.BynderMetaPropertyXMLServiceImpl;
import com.mycompany.bynder.service.xml.BynderXMLService;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mycompany.bynder.DomainUtils.newXMLMedia;
import static com.mycompany.bynder.DomainUtils.newXMLMetaProperty;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class XMLMetaPropertyWriterServiceTest {

    @Test
    public void shouldWriteFromMetaproperty() throws IllegalAccessException, JAXBException, IOException {
        //given
        BynderAssetService mockBynderAssetService = mock(BynderAssetService.class);

        Map<String, BynderMetaproperty> dummyList = new HashMap<String, BynderMetaproperty>(2);
        dummyList.put("Colour", newXMLMetaProperty("first one"));
        dummyList.put("bob_button", newXMLMetaProperty("second one"));
        BynderMetapropertyCollection bynderMetapropertyCollection = new BynderMetapropertyCollection(dummyList);

        when(mockBynderAssetService.synchronousQuery()).thenReturn(bynderMetapropertyCollection);

        //when

        BynderXMLService bynderXMLService = new BynderMetaPropertyXMLServiceImpl();
        File xmlFile = bynderXMLService.toXMLFile("xmlMetapropertyFile.xml", bynderMetapropertyCollection);

        JAXBContext jaxbContext = JAXBContext.newInstance(BynderMetapropertyCollection.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        BynderMetapropertyCollection unmarshal = (BynderMetapropertyCollection) unmarshaller.unmarshal(xmlFile);

        //then
        assertThat(bynderMetapropertyCollection).isEqualTo(unmarshal);

        System.out.println(bynderXMLService.toXMLString(bynderMetapropertyCollection));


    }
}
