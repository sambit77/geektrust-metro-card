package com.geektrust.backend.entities;

public class Card {

    private String id;
    private int balance;
    private boolean isSecondJourney = false;

    public boolean isSecondJourney() {
        return isSecondJourney;
    }

    public void setSecondJourney(boolean isSecondJourney) {
        this.isSecondJourney = isSecondJourney;
    }

    public Card(String id, int balannce)
    {
        this.id = id;
        this.balance = balannce;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

 


    
}
