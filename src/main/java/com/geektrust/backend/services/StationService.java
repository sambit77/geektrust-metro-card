package com.geektrust.backend.services;

import com.geektrust.backend.entities.BaseStation;
import com.geektrust.backend.entities.Card;
import com.geektrust.backend.entities.PassengerType;
import com.geektrust.backend.repositories.ICardRepository;
import java.util.*;

public class StationService implements IStationService{
    private final ICardRepository cardRepository;

    public StationService(ICardRepository cardRepository)
    {
        this.cardRepository = cardRepository;
    }

    @Override
    public void checkIn(Card card, PassengerType passengerType, BaseStation station) {
        /*Comput the cost of the journey */

        int cost = passengerType.getCost();
        int discount = 0;
        if(card.isSecondJourney())
        {
            discount = cost / 2;
            cost = cost - discount;
            card.setSecondJourney(false);
        }
        else
        {
            card.setSecondJourney(true);
        }

        
        int card_balance = card.getBalance();

        if(card_balance >= cost)
        {
            card_balance = card_balance - cost;
        }
        else
        {
            int due = cost - card_balance;
            int service_charge = (int) ((0.02) * due);
            cost = cost + service_charge;
            card_balance = 0;
        }

        
        card.setBalance(card_balance);
        cardRepository.save(card);

        station.setTotal_collection( station.getTotal_collection()+cost);
        station.setTotal_discount(station.getTotal_discount()+discount);

        //populate passenger counts by passenger type
        populatePassengerCountForTheStation(station,passengerType);
        
    }

    private void populatePassengerCountForTheStation(BaseStation station, PassengerType passengerType) {
        // TODO Auto-generated method stub
        HashMap<String,Integer> passengerCountByTypeMap = station.getPassengerCountByTypeMap();
        String passengerKey = "";

        if(PassengerType.ADULT == passengerType)
        {
            passengerKey = "ADULT";
        }
        else if(PassengerType.KID == passengerType)
        {
            passengerKey = "KID";
        }
        else if(PassengerType.SENIOR_CITIZEN == passengerType)
        {
            passengerKey = "SENIOR_CITIZEN";
        }

        //updatemap 
        int count = passengerCountByTypeMap.get(passengerKey);
        count++;
        passengerCountByTypeMap.put(passengerKey, count);
        station.setPassengerCountByTypeMap(passengerCountByTypeMap); 
        
    }

    public int computeCostOfJourney()
    {
        return 0;
    }

    //Sort a hashmap by its value , if vlaue is equal for any entries sort their keys alphabetically 
    public HashMap<String,Integer> sortHashMap(HashMap<String,Integer> map)
    {
        List<Map.Entry<String, Integer> > list =
        new LinkedList<Map.Entry<String, Integer> >(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1, 
                               Map.Entry<String, Integer> o2)
            {
                if(o1.getValue() < o2.getValue())
                {
                    return 1;
                }
                else if(o1.getValue() > o2.getValue())
                {
                    return -1;
                }
                else
                {
                    if(o1.getKey().charAt(0) > o2.getKey().charAt(0))
                    {
                        return 1;
                    }
                    else
                    {
                        return -1;
                    }
                }
            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    //Prints summary (Total collection , discount and passenger count)
    public void printSummary(BaseStation station)
    {
        HashMap<String,Integer> sortedPassengerCountByType = sortHashMap(station.getPassengerCountByTypeMap());
        String name = station.getName();
        int travel_charges = station.getTotal_collection();
        int discount = station.getTotal_discount();

        System.out.println("TOTAL COLLECTION  "+name+" "+travel_charges+" "+discount);
        System.out.println("PASSENGER_TYPE_SUMMARY");

        for (Map.Entry<String, Integer> en : sortedPassengerCountByType.entrySet()) {
            if(en.getValue()>0)
            System.out.println(en.getKey() +" "+ en.getValue());          
        }

    }

}
