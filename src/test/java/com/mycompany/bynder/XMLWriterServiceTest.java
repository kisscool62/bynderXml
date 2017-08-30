package com.mycompany.bynder;

import com.mycompany.bynder.domain.media.BynderMedia;
import com.mycompany.bynder.domain.media.BynderMediaCollection;
import com.mycompany.bynder.service.bynder.BynderAssetService;
import com.mycompany.bynder.service.xml.BynderMediaXMLServiceImpl;
import com.mycompany.bynder.service.xml.BynderXMLService;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.mycompany.bynder.DomainUtils.newXMLMedia;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class XMLWriterServiceTest {

    @Test
    public void shouldWriteFromMedia() throws IllegalAccessException, JAXBException, IOException {
        //given
        BynderAssetService mockBynderAssetService = mock(BynderAssetService.class);

        List<BynderMedia> dummyList = new ArrayList<BynderMedia>(2);
        dummyList.add(newXMLMedia("first one"));
        dummyList.add(newXMLMedia("second one"));
        BynderMediaCollection bynderMediaCollection = new BynderMediaCollection(dummyList);

        when(mockBynderAssetService.synchronousQuery()).thenReturn(bynderMediaCollection);

        //when

        BynderXMLService bynderXMLService = new BynderMediaXMLServiceImpl();
        File xmlFile = bynderXMLService.toXMLFile("xmlFile.xml", bynderMediaCollection);

        JAXBContext jaxbContext = JAXBContext.newInstance(BynderMediaCollection.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        BynderMediaCollection unmarshal = (BynderMediaCollection) unmarshaller.unmarshal(xmlFile);

        //then
        assertThat(bynderMediaCollection).isEqualTo(unmarshal);

        //System.out.println(bynderXMLService.toXMLString(bynderMediaCollection));


    }
}
