package com.example.kebbi_ridebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView rideList;
    Button newRideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rideList = findViewById(R.id.ride_list);
        newRideButton = findViewById(R.id.new_ride_button);

    }

    /** Called When user wants to create a new ride*/
    public void newRide(View view){
        Intent intent = new Intent(this, NewRideActivity.class);
        startActivity(intent);
    }
}
