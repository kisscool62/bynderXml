package com.mycompany.bynder.service.bynder;

import com.bynder.sdk.model.Media;

import java.util.List;

/**
 * Created by pauregan for Serial Development. serial.ch
 */
public interface BynderMediaService {

    List<Media> synchronousQuery() throws IllegalAccessException;

}
