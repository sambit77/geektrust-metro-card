package com.geektrust.backend.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.geektrust.backend.services.StationFactory;

@DisplayName("sattion Test")
public class StationTest {
    
    @Test
    @DisplayName("Test Airport Entity")
    public void testAirport()
    {
        BaseStation airport = StationFactory.getStationEntity("AIRPORT");
        Assertions.assertTrue(airport instanceof AirportStation);
    }

    @Test
    @DisplayName("Test Central Entity")
    public void testCentral()
    {
        BaseStation central = StationFactory.getStationEntity("CENTRAL");
        Assertions.assertTrue(central instanceof CentralStation);
    }
}
