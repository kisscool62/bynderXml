package com.mycompany.bynder;


import com.bynder.sdk.model.Media;
import com.mycompany.bynder.domain.BinderMedia;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DomainUtils {

    public static BinderMedia newXMLMedia(String id){
        final BinderMedia newMedia = mock(BinderMedia.class);
//        when(newMedia.getArchive()).thenReturn(true);
//        when(newMedia.getId()).thenReturn(id);
//        when(newMedia.getFileSize()).thenReturn(42L);
//        when(newMedia.getHeight()).thenReturn(375);
//        when(newMedia.getArchive()).thenReturn(true);
        return newMedia;
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
