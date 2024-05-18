package com.geektrust.backend.repositories;

import com.geektrust.backend.entities.Card;
import java.util.*;

public class CardRepository implements ICardRepository{

    private final Map<String,Card> cardMap;

    public CardRepository()
    {
        cardMap = new HashMap<String,Card>();
    }

    public CardRepository(HashMap<String,Card> cardMap)
    {
        this.cardMap = cardMap;
    }

    @Override
    public Card save(Card entity) {
    
        cardMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public List<Card> findAll() {
        
       List<Card> allCards = new ArrayList<Card>();

       for(String key : cardMap.keySet())
       {
        allCards.add(cardMap.get(key));
       }

       return allCards;
    }

    @Override
    public Optional<Card> findById(String id) {
        
       return Optional.ofNullable(cardMap.get(id));
    }

    @Override
    public boolean existsById(String id) {
       
        boolean isExists = false;

        if(cardMap.containsKey(id))
        {
            isExists = true;
        }

        return isExists;
    }

    @Override
    public void delete(Card entity) {
        
       //cardMap.remove(entity);
    }

    @Override
    public void deleteById(String id) {
       
        cardMap.remove(id);
    }

    @Override
    public long count() {
       
        return cardMap.size();
    }
    
}
