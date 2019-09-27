package com.example.kebbi_ridebook;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RideDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_detail);

        TextView title = findViewById(R.id.title_ride);
        TextView date = findViewById(R.id.date_ride);
        TextView time = findViewById(R.id.time_ride);
        TextView distance = findViewById(R.id.distance_ride);
        TextView speed = findViewById(R.id.speed_ride);
        TextView cadence = findViewById(R.id.cadence_ride);
        TextView comment = findViewById(R.id.comment_ride);

        Intent intent = getIntent();

        Ride ride = (Ride) intent.getExtras().getSerializable("RIDE");

        if (ride != null) {
            title.setText(ride.getTitle());
            date.setText(ride.getDate());
            time.setText(ride.getTime());
            distance.setText(String.valueOf(ride.getDistance()));
            speed.setText(String.valueOf(ride.getAverageSpeed()));
            cadence.setText(String.valueOf(ride.getAverageCadence()));
            comment.setText(ride.getComment());
        }else{
            System.out.println("Something didnt work :(");
        }

    }
}
