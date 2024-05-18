package com.geektrust.backend.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Card Entity Test")
public class CardTest {

    @Test
    @DisplayName("Tests card entity instantiaion")
    public void testCardEntity()
    {
        Card card = new Card("MC1", 100);
        Assertions.assertEquals("MC1", card.getId());
        Assertions.assertEquals(100, card.getBalance());
        card.setBalance(500);
        Assertions.assertEquals(500, card.getBalance());

    }
    
}
