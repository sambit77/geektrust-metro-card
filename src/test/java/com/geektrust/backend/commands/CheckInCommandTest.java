package com.geektrust.backend.commands;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.geektrust.backend.entities.BaseStation;
import com.geektrust.backend.entities.Card;
import com.geektrust.backend.exceptions.CardNotFoundException;
import com.geektrust.backend.services.ICardService;
import com.geektrust.backend.services.IStationService;

@DisplayName("check-In Command Test")
@ExtendWith(MockitoExtension.class)
public class CheckInCommandTest {

    @Mock
    private ICardService cardService;
    @Mock
    private IStationService stationService;

    @InjectMocks
    private CheckInCommand checkInCommand;

    
    @BeforeEach
    public void setup()
    {

    }


    @Test
    @DisplayName("Test execute method for checkin command")
    public void testCheckInCommand() throws Exception
    {
        Card card = new Card("MC1",5000);
        Mockito.when(cardService.getCardById("MC1")).thenReturn(card);

        List<String> inputCommand = new ArrayList<>();
        inputCommand.add("CHECK-IN");
        inputCommand.add("MC1");
        inputCommand.add("ADULT");
        inputCommand.add("AIRPORT");
        checkInCommand.execute(inputCommand);
        Mockito.verify(stationService,times(1)).checkIn(any(Card.class), any(), any(BaseStation.class));
        
    }

    
}
