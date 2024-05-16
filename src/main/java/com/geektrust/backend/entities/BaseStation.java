package com.geektrust.backend.entities;

import java.util.*;

public interface BaseStation {
    public String getName();
    public int getTotal_collection();
    public int getTotal_discount();
    public void setTotal_discount(int total_discount);
    public void setTotal_collection(int total_collection);
    public HashMap<String, Integer> getPassengerCountByTypeMap();
    public void setPassengerCountByTypeMap(HashMap<String, Integer> passengerCountByTypeMap);


    
}
