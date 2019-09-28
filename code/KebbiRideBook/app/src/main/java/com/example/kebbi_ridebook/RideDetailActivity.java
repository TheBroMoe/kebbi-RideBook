package com.example.kebbi_ridebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
            date.setText(String.format("Ride Date: %s", ride.getDate()));
            time.setText(String.format("Time of Ride: %s", ride.getTime()));
            distance.setText(String.format("Ride Distance: %1$,.2f km", ride.getDistance()));
            speed.setText(String.format("Average Speed: %1$,.2f km/h", ride.getAverageSpeed()));
            cadence.setText(String.format("Average Cadence: %d revs/min", ride.getAverageCadence()));
            comment.setText(String.format("Comment:\n%s", ride.getComment()));
        }else{
            System.out.println("Something didnt work :(");
        }

    }

    public void returnAction(View view) {
        finish();
    }
}
