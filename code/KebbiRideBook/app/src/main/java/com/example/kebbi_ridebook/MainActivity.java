package com.example.kebbi_ridebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RideEditorFragment.OnFragmentInteractionListener, AdapterView.OnItemClickListener {
    private ListView rideList;
    private ArrayAdapter<Ride> rideAdapter;
    private ArrayList<Ride> rideDataList;
    private TextView totalDistance;
    private UserInterfaceMain uiMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.uiMain = new UserInterfaceMain();

        this.initialize();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        this.uiMain.setCurrentPostion(position);

        if (this.uiMain.isEditButtonPressed()){
            this.edit();
        } else if(this.uiMain.isDeleteButtonPressed()){
            if (!rideDataList.isEmpty()){
                this.delete();
            }
        } else {
            this.loadDetailActivity();
        }
    }

    // Initialize Variables used for Activity
    private void initialize() {
        totalDistance = findViewById(R.id.total_distance);
        rideList = findViewById(R.id.ride_list);

        rideDataList = new ArrayList<>();
        rideAdapter = new RideList(this, rideDataList);
        rideList.setAdapter(rideAdapter);
        rideList.setOnItemClickListener(this);

        rideAdapter.add(new Ride());

        this.uiMain.updateTotalDistance(rideDataList, totalDistance);

    }

    // Button OnClick Functions

    public void newAction(View view){
        this.uiMain.clearButtonPresses();
        new RideEditorFragment().show(getSupportFragmentManager(), "ADD_RIDE");
    }

    public void deleteAction(View view){
        this.uiMain.setDeleteButton();
    }

    public void editAction(View view){
        this.uiMain.setEditButton();
    }

    // Ride Fragment Interface Functions

    @Override
    public void onOkPressed(Ride newRide) {
        if(this.uiMain.isEditButtonPressed()){
            this.editRide(newRide);
        }else{
            this.addRide(newRide);
        }
        this.uiMain.updateTotalDistance(rideDataList, totalDistance);
        this.uiMain.resetCurrentPosition();
    }

    @Override
    public void onCancelPressed() {
        this.uiMain.clearButtonPresses();
    }

    // Helper Functions

    private void edit() {
        new RideEditorFragment(rideDataList.get(this.uiMain.getCurrentPostion())).show(getSupportFragmentManager(), "EDIT_CITY");
    }

    private void delete() {
        rideDataList.remove(this.uiMain.getCurrentPostion());
        rideList.invalidateViews();
        this.uiMain.updateTotalDistance(rideDataList, totalDistance);
        this.uiMain.clearButtonPresses();
        this.uiMain.resetCurrentPosition();
    }

    private void loadDetailActivity() {
        Intent intent = new Intent(this, RideDetailActivity.class);
        Ride ride = rideDataList.get(this.uiMain.getCurrentPostion());
        intent.putExtra("RIDE", ride);
        startActivity(intent);
        this.uiMain.resetCurrentPosition();
    }

    private void editRide(Ride newRide) {
        rideDataList.set(this.uiMain.getCurrentPostion(), newRide);
        rideAdapter.notifyDataSetChanged();
        this.uiMain.clearButtonPresses();
    }

    private void addRide(Ride newRide) {
        rideAdapter.add(newRide);
    }


}
