package com.example.kebbi_ridebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RideDetailActivity extends AppCompatActivity {

    private TextView title;
    private TextView date;
    private TextView time;
    private TextView distance;
    private TextView speed;
    private TextView cadence;
    private TextView comment;

    private Ride ride;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_detail);

        this.initializeTextViews();

        this.getRideDetails();

        if (ride != null) {
            this.setTextViews();
        }

    }

    private void getRideDetails() {
        Intent intent = getIntent();
        this.ride = (Ride) intent.getExtras().getSerializable("RIDE");
    }

    private void setTextViews() {
        title.setText(ride.getTitle());
        date.setText(String.format("Ride Date: %s", this.ride.getDate()));
        time.setText(String.format("Time of Ride: %s", this.ride.getTime()));
        distance.setText(String.format("Ride Distance: %1$,.2f km", this.ride.getDistance()));
        speed.setText(String.format("Average Speed: %1$,.2f km/h", this.ride.getAverageSpeed()));
        cadence.setText(String.format("Average Cadence: %d revs/min", this.ride.getAverageCadence()));
        comment.setText(String.format("Comment:\n%s", this.ride.getComment()));
    }

    private void initializeTextViews() {
        title = findViewById(R.id.title_ride);
        date = findViewById(R.id.date_ride);
        time = findViewById(R.id.time_ride);
        distance = findViewById(R.id.distance_ride);
        speed = findViewById(R.id.speed_ride);
        cadence = findViewById(R.id.cadence_ride);
        comment = findViewById(R.id.comment_ride);
    }

    public void returnAction(View view) {
        finish();
    }
}
