package com.geektrust.backend.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.geektrust.backend.entities.BaseStation;
import com.geektrust.backend.entities.Card;
import com.geektrust.backend.entities.PassengerType;
import com.geektrust.backend.repositories.ICardRepository;

@DisplayName("StationService Test")
@ExtendWith(MockitoExtension.class)
public class StationServiceTest {

    @Mock
    private ICardRepository cardRepository;

    @InjectMocks
    private StationService stationService;

    private BaseStation airport;
    private BaseStation central;
    @BeforeEach
    public void setup()
    {
        airport = StationFactory.getStationEntity("AIRPORT");
        central = StationFactory.getStationEntity("CENTRAL");

        airport.setTotal_collection(0);
        central.setTotal_collection(0);
    }
    @Test
    @DisplayName("Adult travelling first time should be charged 200")
    public void testAdultCheckIn()
    {
        Integer preCheckInBalance = 500;
        Card card = new Card("MC1",preCheckInBalance);
        PassengerType passengerType = PassengerType.ADULT;
        BaseStation station = airport;

        stationService.checkIn(card, passengerType, station);
        Integer postCheckInBalance = card.getBalance();
        Integer deductedBalance = preCheckInBalance-postCheckInBalance ;

        Assertions.assertEquals(200, deductedBalance);
        Assertions.assertEquals(200, station.getTotal_collection());
    }

    @Test
    @DisplayName("Kid travelling first time should be charged 50")
    public void testKidCheckIn()
    {
        Integer preCheckInBalance = 500;
        Card card = new Card("MC2",preCheckInBalance);
        PassengerType passengerType = PassengerType.KID;
        BaseStation station = airport;

        stationService.checkIn(card, passengerType, station);
        Integer postCheckInBalance = card.getBalance();
        Integer deductedBalance = preCheckInBalance-postCheckInBalance;

        Assertions.assertEquals(50, deductedBalance);
        Assertions.assertEquals(50, station.getTotal_collection());
    }

    @Test
    @DisplayName("senior citizen travelling first time should be charged 50")
    public void testSeniorCheckIn()
    {
        Integer preCheckInBalance = 500;
        Card card = new Card("MC3",preCheckInBalance);
        PassengerType passengerType = PassengerType.SENIOR_CITIZEN;
        BaseStation station = airport;

        stationService.checkIn(card, passengerType, station);
        Integer postCheckInBalance = card.getBalance();
        Integer deductedBalance = preCheckInBalance-postCheckInBalance;

        Assertions.assertEquals(100, deductedBalance);
        Assertions.assertEquals(100, station.getTotal_collection());
    }

    @AfterEach
    public void destroyAllStations()
    {
        StationFactory.destroyAllStation();
    }

   
    
}
