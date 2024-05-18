package com.geektrust.backend.repositories;

import java.util.HashMap;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.geektrust.backend.entities.Card;

public class CardRepositoryTest {

    private ICardRepository cardRepository;

    @BeforeEach
    void setup()
    {
         Card card1 = new Card("MC1",2000);
         Card card2 = new Card("MC2",678);
         Card card3 = new Card("MC3",10000);

         HashMap<String,Card> cardMap = new HashMap<>();
         cardMap.put(card1.getId(), card1);
         cardMap.put(card2.getId(), card2);
         cardMap.put(card3.getId(), card3);
         
         cardRepository = new CardRepository(cardMap);
    }

    @Test
    @DisplayName("save method should create and return new card")
    public void testSaveEntity()
    {
        Card samplecard = new Card("MC8",60000);
        Card actualResult = cardRepository.save(samplecard);
        Assertions.assertEquals(samplecard, actualResult);;
    }

    @Test
    @DisplayName("Find / exists method should return the card if found on repository")
    public void testExistsAndFindById()
    {   
        boolean isFound = cardRepository.existsById("MC1");
        Optional<Card> actualOptCard = cardRepository.findById("MC1");
        Card actualCard = actualOptCard.get();
        Assertions.assertEquals("MC1",actualCard.getId());
        Assertions.assertTrue(isFound);

    }
    
}
