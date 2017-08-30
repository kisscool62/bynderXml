package com.mycompany.bynder;

import com.mycompany.bynder.domain.metaproperty.BynderMetaproperty;
import com.mycompany.bynder.domain.metaproperty.BynderMetapropertyCollection;
import com.mycompany.bynder.service.bynder.BynderAssetService;
import com.mycompany.bynder.service.xml.api.BynderMetapropertyXMLService;
import com.mycompany.bynder.service.xml.impl.BynderMetaPropertyXMLServiceImpl;
import com.mycompany.bynder.service.xml.api.BynderXMLService;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

        BynderMetapropertyXMLService bynderXMLService = new BynderMetaPropertyXMLServiceImpl();
        File xmlFile = bynderXMLService.toXMLFile("xmlMetapropertyFile.xml", bynderMetapropertyCollection);


        BynderMetapropertyCollection unmarshal = bynderXMLService.fromXMLFile(xmlFile);

        //then
        assertThat(bynderMetapropertyCollection).isEqualTo(unmarshal);

        // System.out.println(bynderXMLService.toXMLString(bynderMetapropertyCollection));


    }
}
