package com.example.kebbi_ridebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RideEditorFragment.OnFragmentInteractionListener, AdapterView.OnItemClickListener {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editButtonPressed = false;
        deleteButtonPressed = false;

        rideList = findViewById(R.id.ride_list);
        newRideButton = findViewById(R.id.new_ride_button);
        deleteRideButton = findViewById(R.id.delete_button);
        editRideButton = findViewById(R.id.edit_button);

        totalDistance = findViewById(R.id.total_distance);

        rideDataList = new ArrayList<>();

        rideAdapter = new RideList(this, rideDataList);

        rideList.setAdapter(rideAdapter);
        
        rideList.setOnItemClickListener(this);

        updateTotalDistance();

    }

    public void newAction(View view){
        editButtonPressed = false;
        deleteButtonPressed = false;
        new RideEditorFragment().show(getSupportFragmentManager(), "ADD_RIDE");
    }

    public void deleteAction(View view){
        editButtonPressed = false;
        deleteButtonPressed = true;
    }

    public void editAction(View view){
        editButtonPressed = true;
        deleteButtonPressed = false;
    }

    @Override
    public void onOkPressed(Ride newRide) {
        if(editButtonPressed){
            rideDataList.set(currentPostion, newRide);
            rideAdapter.notifyDataSetChanged();
            editButtonPressed = false;
            deleteButtonPressed = false;
        }else{
            rideAdapter.add(newRide);
        }
        updateTotalDistance();
        currentPostion = -1;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (editButtonPressed){
            currentPostion = position;
            new RideEditorFragment(rideDataList.get(currentPostion)).show(getSupportFragmentManager(), "EDIT_CITY");

        } else if(deleteButtonPressed){
            if (!rideDataList.isEmpty()){
                rideDataList.remove(position);
                rideList.invalidateViews();
                updateTotalDistance();

                editButtonPressed = false;
                deleteButtonPressed = false;
                currentPostion = -1;
            }
        } else {
            Intent intent = new Intent(this, RideDetailActivity.class);
            Ride ride = rideDataList.get(position);
            intent.putExtra("RIDE", ride);
            startActivity(intent);
            currentPostion = -1;
        }
    }

    public void updateTotalDistance(){
        double distance = 0;
        for(int i = 0; i< rideDataList.size(); i++ ){
            distance += rideDataList.get(i).getDistance();
        }

        totalDistance.setText(String.format("Total Distance: %1$,.2f km", distance));

    }
}
