package com.productive;

import java.util.Arrays;

public class IPad {
    private String description;

    public IPad(String description) {
        this.description = description;
    }

    public int getPrice(AppleStore appleStore) {
        return appleStore.calculatePrice(Arrays.asList(description.split(",")));
    }
}
