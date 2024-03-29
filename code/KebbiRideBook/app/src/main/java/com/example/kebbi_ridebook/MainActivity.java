/**
 * MainActivity implements main screen for RideBook
 *
 * Acknowledgements:
 *  Creating a Gradient Background: https://howcreateit.com/programming/android-studio/how-to-set-gradient-background-color-in-android-studio/
 *  Using Serializable to pass objects between activities: https://stackoverflow.com/a/2736612
 * */

package com.example.kebbi_ridebook;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kebbi_ridebook.userinterface.UserInterfaceMain;

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

    // Implementing onItemClick for List Items
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        this.uiMain.setCurrentPosition(position);

        if (this.uiMain.isEditButtonPressed()){
            this.edit();
        } else if(this.uiMain.isDeleteButtonPressed()){
            this.delete();
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
        new RideEditorFragment(rideDataList.get(this.uiMain.getCurrentPosition())).show(getSupportFragmentManager(), "EDIT_CITY");
    }

    private void delete() {
        if (!rideDataList.isEmpty()) {
            rideDataList.remove(this.uiMain.getCurrentPosition());
            rideList.invalidateViews();
            this.uiMain.updateTotalDistance(rideDataList, totalDistance);
            this.uiMain.clearButtonPresses();
            this.uiMain.resetCurrentPosition();
        }
    }

    private void loadDetailActivity() {
        Intent intent = new Intent(this, RideDetailActivity.class);
        Ride ride = rideDataList.get(this.uiMain.getCurrentPosition());
        this.uiMain.resetCurrentPosition();
        intent.putExtra("RIDE", ride);
        startActivity(intent);
    }

    private void editRide(Ride newRide) {
        rideDataList.set(this.uiMain.getCurrentPosition(), newRide);
        rideAdapter.notifyDataSetChanged();
        this.uiMain.clearButtonPresses();
    }

    private void addRide(Ride newRide) {
        rideAdapter.add(newRide);
    }

}
