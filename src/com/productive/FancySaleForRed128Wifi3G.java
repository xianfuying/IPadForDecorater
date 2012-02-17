package com.productive;

import java.util.List;

public class FancySaleForRed128Wifi3G implements MultiFeaturePricingStrategy {

    public int calculate(List<String> features, int price) {
        if (features.contains("red") && features.contains("wifi-3G") && features.contains("128")) {
                    price = (int) (price - (3200 + 3200 + 400 + 3688) * 0.2);
                }
        return price;
    }
}
