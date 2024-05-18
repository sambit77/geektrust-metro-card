package com.geektrust.backend.commands;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.geektrust.backend.entities.Card;
import com.geektrust.backend.services.ICardService;

@DisplayName("Balance Command Test")
@ExtendWith(MockitoExtension.class)
public class BalanceCommandTest {
    
    @Mock
    private ICardService cardServiceMock;

    @InjectMocks
    private BalanceCommand balanceCommand;

    @Test
    @DisplayName("Balance command should create & return a card with given balance")
    public void testBalanceCommand()
    {   
        Card card = new Card("MC1",5000);
        Mockito.when(cardServiceMock.createCard(anyString(), anyInt())).thenReturn(card);

        List<String> balanceCommandInput = new ArrayList<>();
        balanceCommandInput.add("BALANCE");
        balanceCommandInput.add("MC1");
        balanceCommandInput.add("500");
        balanceCommand.execute(balanceCommandInput);
        //Assertions.assertEquals(card.getId(), newCardID);
        Mockito.verify(cardServiceMock,times(1)).createCard(anyString(), anyInt());
    }
    
}
