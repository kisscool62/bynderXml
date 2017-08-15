package com.mycompany.bynder;

import com.bynder.sdk.model.Media;
import com.bynder.sdk.service.BynderService;
import com.mycompany.bynder.service.bynder.BynderServiceFactory;

import java.net.MalformedURLException;
import java.util.List;

import static com.mycompany.bynder.service.bynder.BynderMediaServiceFactory.create;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IllegalAccessException, MalformedURLException {
        BynderService bynderService = BynderServiceFactory.create(
                        "https://example.bynder.com",
                        "consumer key",
                        "consumer secret",
                        "token",
                        "token secret");

        List<Media> medias = create(bynderService).synchronousQuery();


    }


}
