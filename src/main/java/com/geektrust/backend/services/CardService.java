package com.geektrust.backend.services;


import com.geektrust.backend.entities.Card;
import com.geektrust.backend.exceptions.CardNotFoundException;
import com.geektrust.backend.repositories.ICardRepository;

public class CardService implements ICardService {
    private final ICardRepository cardRepository;

    public CardService(ICardRepository cardRepository)
    {
        this.cardRepository = cardRepository;
    }

    public Card createCard(String id,int balance)
    {
        Card card = new Card(id,balance);
        cardRepository.save(card);
        return card;
    }

    public Card getCardById(String id) throws CardNotFoundException
    {
        final Card card = cardRepository.findById(id).orElseThrow(() -> new CardNotFoundException(id+" does not exits in Card Repository"));
        return card;
    }
 
}
