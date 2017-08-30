package com.mycompany.bynder.service.bynder;


import com.bynder.sdk.model.Settings;
import com.bynder.sdk.service.BynderService;
import com.bynder.sdk.service.impl.BynderServiceImpl;
import com.google.common.base.Preconditions;

import java.net.MalformedURLException;
import java.net.URL;


public class BynderServiceFactory {


    public static BynderService create(
            String urlString,
            String consumerKey,
            String consumerSecret,
            String token,
            String tokenSecret) throws MalformedURLException {


        checkNotNull(urlString);
        checkNotNull(consumerKey);
        checkNotNull(consumerSecret);
        checkNotNull(token);
        checkNotNull(tokenSecret);

        return BynderServiceImpl.create(
                new Settings(
                        new URL(urlString),
                        consumerKey,
                        consumerSecret,
                        token,
                        tokenSecret));

    }

    private static void checkNotNull(String object) {

    }
}
