import RideAttributes.*;

/**
 * The Ride Class encapsulates a ride and it's attributes
 * when a user creates a ride
 *
 * @author  Mohammad Kebbi
 * @version 1.0
 * @since   2019-9-18
 */

public class Ride {

    // Attributes
    private String id;
    private Title title;
    private Date date;
    private Time time;

    private Distance distance;
    private float distanceFloat;

    private AverageSpeed averageSpeed;
    private float averageSpeedFloat;

    private AverageCadence averageCadence;
    private int averageCadenceInt;

    private Comment comment;

    // Constructor
    public Ride(String id){
        this.id = id;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public AverageSpeed getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(AverageSpeed averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public AverageCadence getAverageCadence() {
        return averageCadence;
    }

    public void setAverageCadence(AverageCadence averageCadence) {
        this.averageCadence = averageCadence;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public float getDistanceFloat() {
        return distanceFloat;
    }

    public void setDistanceFloat(float distanceFloat) {
        this.distanceFloat = distanceFloat;
    }

    public float getAverageSpeedFloat() {
        return averageSpeedFloat;
    }

    public void setAverageSpeedFloat(float averageSpeedFloat) {
        this.averageSpeedFloat = averageSpeedFloat;
    }

    public int getAverageCadenceInt() {
        return averageCadenceInt;
    }

    public void setAverageCadenceInt(int averageCadenceInt) {
        this.averageCadenceInt = averageCadenceInt;
    }
}
