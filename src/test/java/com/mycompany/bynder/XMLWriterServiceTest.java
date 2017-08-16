package com.mycompany.bynder;

import com.mycompany.bynder.domain.media.BynderMedia;
import com.mycompany.bynder.domain.media.BynderMedias;
import com.mycompany.bynder.service.bynder.BynderMediaService;
import com.mycompany.bynder.service.xml.BynderMediaXMLServiceImpl;
import com.mycompany.bynder.service.xml.BynderXMLService;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static com.mycompany.bynder.DomainUtils.newXMLMedia;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class XMLWriterServiceTest {

    @Test
    public void shouldWriteFromMedia() throws IllegalAccessException, JAXBException, FileNotFoundException {
        //given
        BynderMediaService mockBynderMediaService = mock(BynderMediaService.class);

        List<BynderMedia> dummyList = new ArrayList<>(2);
        dummyList.add(newXMLMedia("first one"));
        dummyList.add(newXMLMedia("second one"));
        BynderMedias bynderMedias = new BynderMedias(dummyList);

        when(mockBynderMediaService.synchronousQuery()).thenReturn(bynderMedias);

        //when

        BynderXMLService bynderXMLService = new BynderMediaXMLServiceImpl();
        File xmlFile = bynderXMLService.toXMLFile("xmlFile.xml", bynderMedias);

        JAXBContext jaxbContext = JAXBContext.newInstance(BynderMedias.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        BynderMedias unmarshal = (BynderMedias) unmarshaller.unmarshal(xmlFile);

        //then
        assertThat(bynderMedias).isEqualTo(unmarshal);

        //System.out.println(bynderXMLService.toXMLString(bynderMedias));


    }
}
