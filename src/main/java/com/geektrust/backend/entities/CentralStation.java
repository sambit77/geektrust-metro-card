package com.geektrust.backend.entities;

import java.util.*;

public class CentralStation implements BaseStation{

    private static CentralStation centralStation;
    private int total_collection;
    private int total_discount;
    private final String name = "CENTRAL";

    HashMap<String,Integer> passengerCountByTypeMap = new HashMap<String,Integer>();

    public CentralStation()
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

    public static CentralStation getCentralstation()
    {
        if(centralStation == null)
        {
            centralStation = new CentralStation();
        }
        return centralStation;
    }

    public static void destroy()
    {
        centralStation = null;
    }
  
    
}
