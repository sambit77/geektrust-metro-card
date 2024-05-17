package com.geektrust.backend.commands;

import java.util.List;
import com.geektrust.backend.entities.BaseStation;
import com.geektrust.backend.entities.Card;
import com.geektrust.backend.entities.PassengerType;
import com.geektrust.backend.exceptions.InvalidPassengerTypeException;
import com.geektrust.backend.exceptions.InvalidStationException;
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

        //Input data validation for Metro Card
        Card card = null;
        try {
            card = cardService.getCardById(cardId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Input data validation for Passenger Type and Station Name
        try{
            if(!(passenger.equals("ADULT") || passenger.equals("KID") || passenger.equals("SENIOR_CITIZEN")))
            {
                throw new InvalidPassengerTypeException(passenger+" is an invalid passenger type");
            }
            if(!(stationName.equals("AIRPORT") || stationName.equals("CENTRAL")))
            {
                throw new InvalidStationException(stationName+" is an invaild station");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();;
        }

        PassengerType passengerType = PassengerType.valueOf(passenger);
        BaseStation station = StationFactory.getStationEntity(stationName);
        stationService.checkIn(card, passengerType, station);
   
    }
    
}
