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

        Preconditions.checkNotNull(urlString);
        Preconditions.checkNotNull(consumerKey);
        Preconditions.checkNotNull(consumerSecret);
        Preconditions.checkNotNull(token);
        Preconditions.checkNotNull(tokenSecret);

        return BynderServiceImpl.create(
                new Settings(
                        new URL(urlString),
                        consumerKey,
                        consumerSecret,
                        token,
                        tokenSecret));

    }
}
