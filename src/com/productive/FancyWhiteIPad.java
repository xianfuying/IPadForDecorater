package com.productive;

public class FancyWhiteIPad implements SingleFeaturePricingStrategy {

    public int calculate(int price, String feature) {
        if (feature.equals("white"))
            price += 200;
        return price;
    }
}
