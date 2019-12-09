package com.udacity.vehicles.client.maps;

import com.udacity.vehicles.domain.Location;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={ MapsClient.class })
public class MapsClientTest {

    @MockBean
    private WebClient webClient;
    @MockBean
    private ModelMapper modelMapper;
    @MockBean
    private MapsClient mapsClient;

    @Before
    public void setup(){
        Mockito.when(
                mapsClient.getAddress(any()))
                .thenReturn(getLocation());
    }
    @Test
    public void getAddress() {

        Location local = mapsClient.getAddress(new Location(40.730610, -73.935242));
        String address = local.getAddress();
        assertThat(address, equalTo("234 Walter Carringhton avenue"));
    }

    private Location getLocation(){

        Location location = new Location(40.730610, -73.935242);
        location.setAddress("234 Walter Carringhton avenue");
        location.setCity("Lagos");
        location.setState("USA");
        location.setZip("9114");

        return location;
    }
}