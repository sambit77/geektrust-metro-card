package com.geektrust.backend.commands;

import java.util.List;

import com.geektrust.backend.entities.Card;
import com.geektrust.backend.services.ICardService;

public class BalanceCommand implements ICommand{

    private final ICardService cardService;

    public BalanceCommand(ICardService cardService)
    {
        this.cardService = cardService;
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        
        String id = tokens.get(1);
        int balance = Integer.parseInt(tokens.get(2));
        String cardId = cardService.createCard(id,balance);

    }
    
}
