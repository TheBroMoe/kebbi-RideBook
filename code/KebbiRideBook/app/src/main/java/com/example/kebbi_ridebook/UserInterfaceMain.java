package com.example.kebbi_ridebook;

import android.widget.TextView;

import java.util.ArrayList;

public class UserInterfaceMain {

    private boolean editButtonPressed;
    private boolean deleteButtonPressed;

    private int currentPosition;

    public UserInterfaceMain(){
        this.clearButtonPresses();
        this.resetCurrentPosition();
    }


    public boolean isEditButtonPressed() {
        return editButtonPressed;
    }

    public void setEditButtonPressed(boolean editButtonPressed) {
        this.editButtonPressed = editButtonPressed;
    }

    public boolean isDeleteButtonPressed() {
        return deleteButtonPressed;
    }

    public void setDeleteButtonPressed(boolean deleteButtonPressed) {
        this.deleteButtonPressed = deleteButtonPressed;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void clearButtonPresses() {
        this.setEditButtonPressed(false);
        this.setDeleteButtonPressed(false);
    }

    public void setDeleteButton() {
        this.setEditButtonPressed(false);
        this.setDeleteButtonPressed(true);
    }

    public void setEditButton() {
        this.setEditButtonPressed(true);
        this.setDeleteButtonPressed(false);
    }

    public void resetCurrentPosition() {
        this.setCurrentPosition(-1);
    }

    public void updateTotalDistance(ArrayList<Ride> rideDataList, TextView totalDistance){
        double distance = 0;
        for(int i = 0; i< rideDataList.size(); i++ ){
            distance += rideDataList.get(i).getDistance();
        }
        totalDistance.setText(String.format("Total Distance: %1$,.2f km", distance));
    }

}
