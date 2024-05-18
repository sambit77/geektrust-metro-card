package com.geektrust.backend.entities;
import java.util.*;

public class AirportStation implements BaseStation {

    public static AirportStation airportStation;
    private int total_collection;
    private int total_discount;
    private final String name = "AIRPORT";
    HashMap<String,Integer> passengerCountByTypeMap = new HashMap<String,Integer>();

    private AirportStation()
    {
        passengerCountByTypeMap.put("KID", 0);
        passengerCountByTypeMap.put("ADULT", 0);
        passengerCountByTypeMap.put("SENIOR_CITIZEN", 0);
    }

    public HashMap<String, Integer> getPassengerCountByTypeMap() {
        return passengerCountByTypeMap;
    }

    public void setPassengerCountByTypeMap(HashMap<String, Integer> passengerCountByTypeMap) {
        this.passengerCountByTypeMap = passengerCountByTypeMap;
    }

    public String getName() {
        return name;
    }

    public int getTotal_collection() {
        return total_collection;
    }

    public void setTotal_collection(int total_collection) {
        this.total_collection = total_collection;
    }

    public int getTotal_discount() {
        return total_discount;
    }

    public void setTotal_discount(int total_discount) {
        this.total_discount = total_discount;
    }

    public static AirportStation getAirportStation()
    {
        if(airportStation == null)
        {
            airportStation = new AirportStation();
        }
        return airportStation;
    }

    public static void destroy()
    {
        airportStation = null;
    }

    
}
