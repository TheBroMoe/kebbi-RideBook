package com.example.kebbi_ridebook;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class UserInterfaceMain {
    private ListView rideList;
    private ArrayAdapter<Ride> rideAdapter;
    private ArrayList<Ride> rideDataList;

    private Button newRideButton;

    private Button editRideButton;
    private Button deleteRideButton;

    private TextView totalDistance;

    private boolean editButtonPressed;
    private boolean deleteButtonPressed;

    private int currentPostion;

    public UserInterfaceMain(){
        this.clearButtonPresses();
        this.resetCurrentPosition();
    }

    public ListView getRideList() {
        return rideList;
    }

    public void setRideList(ListView rideList) {
        this.rideList = rideList;
    }

    public ArrayAdapter<Ride> getRideAdapter() {
        return rideAdapter;
    }

    public void setRideAdapter(ArrayAdapter<Ride> rideAdapter) {
        this.rideAdapter = rideAdapter;
    }

    public ArrayList<Ride> getRideDataList() {
        return rideDataList;
    }

    public void setRideDataList(ArrayList<Ride> rideDataList) {
        this.rideDataList = rideDataList;
    }

    public Button getNewRideButton() {
        return newRideButton;
    }

    public void setNewRideButton(Button newRideButton) {
        this.newRideButton = newRideButton;
    }

    public Button getEditRideButton() {
        return editRideButton;
    }

    public void setEditRideButton(Button editRideButton) {
        this.editRideButton = editRideButton;
    }

    public Button getDeleteRideButton() {
        return deleteRideButton;
    }

    public void setDeleteRideButton(Button deleteRideButton) {
        this.deleteRideButton = deleteRideButton;
    }

    public TextView getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(TextView totalDistance) {
        this.totalDistance = totalDistance;
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

    public int getCurrentPostion() {
        return currentPostion;
    }

    public void setCurrentPostion(int currentPostion) {
        this.currentPostion = currentPostion;
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
        this.setCurrentPostion(-1);
    }

    public void updateTotalDistance(ArrayList<Ride> rideDataList, TextView totalDistance){
        double distance = 0;
        for(int i = 0; i< rideDataList.size(); i++ ){
            distance += rideDataList.get(i).getDistance();
        }
        totalDistance.setText(String.format("Total Distance: %1$,.2f km", distance));
    }

}
