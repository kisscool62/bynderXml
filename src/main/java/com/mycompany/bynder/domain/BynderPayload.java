package com.mycompany.bynder.domain;

import lombok.Getter;

import javax.ws.rs.client.Entity;

import static javax.ws.rs.client.Entity.json;

@Getter
public abstract class BynderPayload<T extends BynderEntity> {
    private final String url;
    private final Entity<T> payload;

    public BynderPayload(String url, T bynderEntity) {
        this.url = url;
        this.payload = json(bynderEntity);
    }
}
