package com.mycompany.bynder.service.bynder;


import com.bynder.sdk.model.Settings;
import com.bynder.sdk.service.BynderService;
import com.bynder.sdk.service.impl.BynderServiceImpl;

import java.net.MalformedURLException;
import java.net.URL;


public class BynderServiceFactory {


    public static BynderService create(
            String urlString,
            String consumerKey,
            String consumerSecret,
            String token,
            String tokenSecret) throws MalformedURLException {

        checkNotNull(urlString, "urlString should not be null");
        checkNotNull(consumerKey, "consumerKey should not be null");
        checkNotNull(consumerSecret, "consumerSecret should not be null");
        checkNotNull(token, "token should not be null");
        checkNotNull(tokenSecret, "tokenSecret should not be null");

        return BynderServiceImpl.create(
                new Settings(
                        new URL(urlString),
                        consumerKey,
                        consumerSecret,
                        token,
                        tokenSecret));

    }

    private static void checkNotNull(Object object, String message) {
        if(object == null){
            throw new IllegalArgumentException(message);
        }
    }
}
