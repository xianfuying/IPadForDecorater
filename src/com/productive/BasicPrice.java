package com.productive;

public class BasicPrice implements SingleFeaturePricingStrategy {

    public int calculate(int price, String feature) {
        if (feature.equals("basic"))
            price += 3688;
        return price;
    }
}
