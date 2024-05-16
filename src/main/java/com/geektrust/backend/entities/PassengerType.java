package com.geektrust.backend.entities;

public enum PassengerType {
    ADULT(200),
    KID(50),
    SENIOR_CITIZEN(100);

    private int cost;

    PassengerType(int cost)
    {
        this.cost = cost;
    }

    public int getCost()
    {
        return cost;
    }

    
}
