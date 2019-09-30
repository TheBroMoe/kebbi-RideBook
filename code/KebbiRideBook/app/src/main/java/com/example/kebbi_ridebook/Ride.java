/**
 * The Ride Class encapsulates a ride and it's attributes
 * when a user creates a ride
 *
 */
package com.example.kebbi_ridebook;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Ride implements Serializable {

    // Attributes
    private String title;


    private String date;
    private String time;

    private double distance;
    private double averageSpeed;
    private int averageCadence;

    private String comment;

    // Empty Constructor Called
    public Ride(){
        this.date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        this.time = new SimpleDateFormat("HH:mm").format(new Date());

        this.title = "New Ride";
        this.comment = "";

        this.distance = 0;
        this.averageSpeed = 0;
        this.averageSpeed = 0;
    }

    // Constructor with all attributes given
    public Ride(String title, String date, String time, double distance, double averageSpeed, int averageCadence, String comment) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.distance = distance;
        this.averageSpeed = averageSpeed;
        this.averageCadence = averageCadence;
        this.comment = comment;

    }

    // Getters and Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) { this.date = date; }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public int getAverageCadence() {
        return averageCadence;
    }

    public void setAverageCadence(int averageCadence) {
        this.averageCadence = averageCadence;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }




}