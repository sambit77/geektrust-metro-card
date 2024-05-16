package com.geektrust.backend.services;

import com.geektrust.backend.entities.AirportStation;
import com.geektrust.backend.entities.BaseStation;
import com.geektrust.backend.entities.CentralStation;

public class StationFactory {

    public static BaseStation getStationEntity(String stationName)
    {
        
        if(stationName.equalsIgnoreCase("AIRPORT"))
        {   
            //System.out.println("Debug " +stationName);
            return AirportStation.getAirportStation();
        }
        else
        {
            return CentralStation.getCentralstation();
        }
    }
    
}
