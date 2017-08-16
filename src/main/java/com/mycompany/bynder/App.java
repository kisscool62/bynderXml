package com.mycompany.bynder;

import com.bynder.sdk.service.BynderService;
import com.mycompany.bynder.service.bynder.BynderServiceFactory;

import java.net.MalformedURLException;

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

        // List<BynderMedia> medias = create(bynderService).synchronousQuery();


    }


}
