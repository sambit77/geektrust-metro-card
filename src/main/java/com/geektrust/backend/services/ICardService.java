package com.geektrust.backend.services;

import com.geektrust.backend.entities.Card;

public interface ICardService {
    public String createCard(String id,int balance);
    public Card getCardById(String id) throws Exception;

}
