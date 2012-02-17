package com.productive;

import java.util.Arrays;
import java.util.List;

public class AppleStore {
    private List<SingleFeaturePricingStrategy> singleFeaturePricingStrategies;
    private List<MultiFeaturePricingStrategy> multiFeaturePricingStrategies;

    public void basicPrice(final int basePrice) {
        singleFeaturePricingStrategies.add(new SingleFeaturePricingStrategy() {
            public int calculate(int price, String feature) {
                return price + basePrice;
            }
        });
    }

    public void color(final String color, final int addition) {
        feature(color, addition);
    }

    public void wireless(final String color, final int addition) {
        feature(color, addition);
    }

    public void memory(final String color, final int addition) {
        feature(color, addition);
    }

    public void discount(final int addition, final String... featureComb) {
        multiFeaturePricingStrategies.add(new MultiFeaturePricingStrategy() {
            public int calculate(List<String> features, int price) {
                return features.containsAll(Arrays.asList(featureComb)) ? price + addition : price;
            }
        });
    }

    private void feature(final String feature, final int addition) {
        singleFeaturePricingStrategies.add(new SingleFeaturePricingStrategy() {
            public int calculate(int price, String feature) {
                return feature.equals(feature) ? price + addition : price;
            }
        });
    }

    public int calculatePrice(List<String> features) {
        int price = getSinglePrice(features);
        price = new FancySaleForRed128Wifi3G().calculate(features, price);
        return price;
    }

    private int getSinglePrice(Iterable<String> features) {
        int price = 0;
        for (String s : features) {
            price = callSingleFeature(price, s, new BasicPrice());
            price = callSingleFeature(price, s, new FancyWhiteIPad());
            if (s.equals("64"))
                price += 2500;
            if (s.equals("red"))
                price += 400;
            if (s.equals("3G"))
                price += 1600;
            if (s.equals("32"))
                price += 1600;
            if (s.equals("128"))
                price += 3200;
            if (s.equals("wifi-3G"))
                price += 3200;
        }
        return price;
    }

    private int callSingleFeature(int price, String s, SingleFeaturePricingStrategy basicPrice) {
        price = basicPrice.calculate(price, s);
        return price;
    }

}
