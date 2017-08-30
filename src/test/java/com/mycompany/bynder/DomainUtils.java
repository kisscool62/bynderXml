package com.mycompany.bynder;


import com.bynder.sdk.model.Media;
import com.bynder.sdk.model.MediaItem;
import com.bynder.sdk.model.MetapropertyOption;
import com.bynder.sdk.query.MetapropertyField;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mycompany.bynder.domain.media.BynderMedia;
import com.mycompany.bynder.domain.metaproperty.BynderMetaproperty;

import java.util.List;
import java.util.Map;

import static com.bynder.sdk.model.MediaType.AUDIO;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DomainUtils {

    public static BynderMedia newXMLMedia(String id){
        List<String> items = Lists.asList("item_1", new String[]{"item_2", "item_3"});
        List<MediaItem> mediaItems = null;
        Map<String, String> map = Maps.newHashMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        String aString = "this string";
        long numberl = 4242L;
        int numberi= 42;

        return BynderMedia.builder()
                .id(id)
                .archive(true)
                .brandId(aString)
                .copyright(aString)
                .dateCreated(aString)
                .dateModified(aString)
                .datePublished(aString)
                .description(aString)
                .extensions(items)
                .fileSize(numberl)
                .height(numberi)
                .isPublic(true)
                .mediaItems(mediaItems)
                .name(aString)
                .orientation(aString)
                .original(aString)
                .tags(items)
                .propertyOptions(items)
                .thumbnails(map)
                .type(AUDIO)
                .videoPreviewURLs(items)
                .width(numberi)
                .build();
    }

    public static BynderMetaproperty newXMLMetaProperty(String id){

        BynderMetaproperty metaproperty = BynderMetaproperty.builder()
                .id(id)
                .isFilterable(true)
                .label("label")
                .name("name")
                .zindex(2)
                .build();
        return metaproperty;
    }

    public static Media newMedia(String id){
        final Media newMedia = mock(Media.class);
        when(newMedia.getArchive()).thenReturn(true);
        when(newMedia.getId()).thenReturn(id);
        when(newMedia.getFileSize()).thenReturn(42L);
        when(newMedia.getHeight()).thenReturn(375);
        when(newMedia.getArchive()).thenReturn(true);
        return newMedia;
    }

}
