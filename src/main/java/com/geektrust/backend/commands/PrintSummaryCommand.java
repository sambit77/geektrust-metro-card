package com.geektrust.backend.commands;

import java.util.List;

import com.geektrust.backend.entities.BaseStation;
import com.geektrust.backend.services.IStationService;
import com.geektrust.backend.services.StationFactory;
import com.geektrust.backend.services.StationFactory;

public class PrintSummaryCommand implements ICommand{
    
    private final IStationService stationService;

    
    public PrintSummaryCommand(IStationService stationService)
    {
        this.stationService = stationService;
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        BaseStation central = StationFactory.getStationEntity("CENTRAL");
        BaseStation airport = StationFactory.getStationEntity("AIRPORT");

        stationService.printSummary(central);
        stationService.printSummary(airport);

        
    }
    
}
