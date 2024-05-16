package com.geektrust.backend.services;

import java.util.Optional;

import com.geektrust.backend.entities.Card;
import com.geektrust.backend.repositories.CardRepository;
import com.geektrust.backend.repositories.ICardRepository;

public class CardService implements ICardService {
    private final ICardRepository cardRepository;

    public CardService(ICardRepository cardRepository)
    {
        this.cardRepository = cardRepository;
    }

    public String createCard(String id,int balance)
    {
        Card card = new Card(id,balance);
        cardRepository.save(card);
        return id;
    }

    public Card getCardById(String id) throws Exception
    {
        final Card card = cardRepository.findById(id).orElseThrow(() -> new Exception());
        
        return card;
    }

    

    
}
