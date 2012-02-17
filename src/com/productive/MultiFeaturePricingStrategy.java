package com.productive;

import java.util.List;

public interface MultiFeaturePricingStrategy {
    int calculate(List<String> features, int price);
}
