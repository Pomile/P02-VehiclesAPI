package com.udacity.vehicles.client.prices;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { PriceClient.class })
public class PriceClientTest {
    @MockBean
    private PriceClient priceClient;
    @MockBean
    private WebClient webClient;

    @Before
    public void setup() {

    }

    @Test
    public void getPrice() {
        Mockito.when(priceClient.getPrice(1L)).thenReturn(carPrice());
        String price = priceClient.getPrice(1L);
        assertThat(price, equalTo("USD 6653.38"));
    }

    private String carPrice(){
        Price price = new Price();
        price.setPrice(new BigDecimal(6653.3767d).setScale(2, RoundingMode.HALF_UP));
        price.setCurrency("USD");
        return String.format("%s %s", price.getCurrency(), price.getPrice() );
    }
}