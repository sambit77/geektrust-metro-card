package com.geektrust.backend.services;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.geektrust.backend.entities.Card;
import com.geektrust.backend.repositories.ICardRepository;

@DisplayName("CardService Test")
@ExtendWith(MockitoExtension.class)
public class CardServiceTest {
    
    @Mock
    private ICardRepository cardRepository;

    @InjectMocks
    private CardService cardService;

    @Test
    @DisplayName("Create a new card with given Id and balance")
    public void testCardCreationService()
    {
        Card expectedCard = new Card("MC100", 6000);

        Mockito.when(cardRepository.save(any())).thenReturn(expectedCard);

        Card actualcard = cardService.createCard("MC100", 6000);
        Assertions.assertEquals(expectedCard.getId(), actualcard.getId());
    }

    
}
