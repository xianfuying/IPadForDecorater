package com.productive;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IPadTest {


    @Test
    public void should_get_price_of_basic_ipad() {
        new AppleStore() {{
            basicPrice(3688);
            
            color("red", +400);
            color("white", +200);

            wireless("wifi", +800);
            wireless("3G", +1600);
            wireless("wifi+3G", +3200);

            memory("16G", +800);
            memory("32G", +1600);
            memory("64G", +2500);
            memory("128G", +3200);

            discount(20, "red", "128G", "wifi+3G");
        }};
        int price = new IPad("basic").getPrice(new AppleStore());
        assertThat(price, is(3688));
    }

    @Test
    public void should_get_price_of_white_basic_ipad() {
        int price = new IPad("white,basic").getPrice(new AppleStore());
        assertThat(price, is(3888));
    }

    @Test
    public void should_get_price_of_white_64_basic_ipad() {
        int price = new IPad("white,64,basic").getPrice(new AppleStore());
        assertThat(price, is(6388));
    }

    @Test
    public void should_get_price_of_red_32_3G_basic_ipad() {
        int price = new IPad("red,32,3G,basic").getPrice(new AppleStore());
        assertThat(price, is(7288));
    }

    @Test
    public void should_get_discount_if_get_red_128_wifi_and_3G_basic_ipad() {
        int price = new IPad("red,128,wifi-3G,basic").getPrice(new AppleStore());
        int expected = (int) ((3688 + 400 + 3200 + 3200) * 0.8);
        assertThat(price, is(expected));
    }
}
