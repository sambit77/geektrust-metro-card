package com.geektrust.backend.repositories;

import com.geektrust.backend.entities.Card;
import java.util.*;

public class CardRepository implements ICardRepository{

    private final Map<String,Card> cardMap;

    public CardRepository()
    {
        cardMap = new HashMap<String,Card>();
    }

    @Override
    public Card save(Card entity) {
        // TODO Auto-generated method stub
        cardMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public List<Card> findAll() {
        // TODO Auto-generated method stub
       List<Card> allCards = new ArrayList<Card>();

       for(String key : cardMap.keySet())
       {
        allCards.add(cardMap.get(key));
       }

       return allCards;
    }

    @Override
    public Optional<Card> findById(String id) {
        // TODO Auto-generated method stub
       return Optional.ofNullable(cardMap.get(id));
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        boolean isExists = false;

        if(cardMap.containsKey(id))
        {
            isExists = true;
        }

        return isExists;
    }

    @Override
    public void delete(Card entity) {
        // TODO Auto-generated method stub
       cardMap.remove(entity);
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        cardMap.remove(id);
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return cardMap.size();
    }
    
}
