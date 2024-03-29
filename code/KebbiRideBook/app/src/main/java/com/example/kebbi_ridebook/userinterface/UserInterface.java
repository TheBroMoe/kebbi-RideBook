/**
 * UserInterface is a base class used to encapsulate helper functions used by each activity
 * */
package com.example.kebbi_ridebook.userinterface;

import com.example.kebbi_ridebook.Ride;

public abstract class UserInterface {
    protected Ride ride;

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }


}
