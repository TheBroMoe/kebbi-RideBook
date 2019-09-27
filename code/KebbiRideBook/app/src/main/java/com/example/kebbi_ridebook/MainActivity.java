package com.example.kebbi_ridebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RideEditorFragment.OnFragmentInteractionListener, AdapterView.OnItemClickListener {
    private ListView rideList;
    private ArrayAdapter<Ride> rideAdapter;
    private ArrayList<Ride> rideDataList;

    private Button newRideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rideList = findViewById(R.id.ride_list);
        newRideButton = findViewById(R.id.new_ride_button);

        rideDataList = new ArrayList<>();

        rideAdapter = new RideList(this, rideDataList);

        rideList.setAdapter(rideAdapter);

        rideAdapter.add(new Ride());

        rideList.setOnItemClickListener(this);
    }

    public void rideEditor(View view){
        new RideEditorFragment().show(getSupportFragmentManager(), "ADD_RIDE");
    }

    @Override
    public void onOkPressed(Ride newRide) {
        rideAdapter.add(newRide);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, RideDetailActivity.class);
        Ride ride = rideDataList.get(position);

        intent.putExtra("RIDE", ride);

        startActivity(intent);

    }
}
