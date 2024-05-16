package com.geektrust.backend.services;

import com.geektrust.backend.entities.BaseStation;
import com.geektrust.backend.entities.Card;
import com.geektrust.backend.entities.PassengerType;

public interface IStationService {
    public void checkIn(Card card,PassengerType passengerType,BaseStation Station);
    public void printSummary(BaseStation station);
}
