package com.geektrust.backend.commands;

import java.util.List;

import com.geektrust.backend.entities.BaseStation;
import com.geektrust.backend.entities.BaseStation;
import com.geektrust.backend.entities.Card;
import com.geektrust.backend.entities.PassengerType;
import com.geektrust.backend.services.ICardService;
import com.geektrust.backend.services.IStationService;
import com.geektrust.backend.services.StationFactory;

public class CheckInCommand implements ICommand {
    private final ICardService cardService;
    private final IStationService  stationService;

    public CheckInCommand(ICardService cardService,IStationService  stationService)
    {
        this.cardService = cardService;
        this.stationService = stationService;
    }
    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub

        String cardId = tokens.get(1);
        String passenger = tokens.get(2);
        String stationName = tokens.get(3);

        //System.out.println(cardId+" "+passenger+" "+stationName+" "+"Debug");

        Card card = null;
        try {
           // System.out.println(cardId+" card id");
            card = cardService.getCardById(cardId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        PassengerType passengerType = PassengerType.valueOf(passenger);
        BaseStation station = StationFactory.getStationEntity(stationName);

        stationService.checkIn(card, passengerType, station);
       

        
    }
    
}
