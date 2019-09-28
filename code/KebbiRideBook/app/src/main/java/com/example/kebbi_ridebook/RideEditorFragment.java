package com.example.kebbi_ridebook;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.Arrays;

public class RideEditorFragment extends DialogFragment {

    private OnFragmentInteractionListener listener;
    private Ride ride;

    private EditText titleName;
    private EditText dateName;
    private EditText timeName;
    private EditText distanceName;
    private EditText speedName;
    private EditText cadenceName;
    private EditText commentName;

    private boolean rideExists;

    // Constructor for Adding New Rides
    public RideEditorFragment(){
        this.rideExists = false;
        this.ride = new Ride();
    }

    // Constructor for Editing Existing Rides
    public RideEditorFragment(Ride ride){
        this.ride = ride;
        this.rideExists = true;

    }

    public boolean isExistingRide() {
        return rideExists;
    }

    public void setRideExists(boolean rideExists) {
        this.rideExists = rideExists;
    }

    public interface OnFragmentInteractionListener {
        void onOkPressed(Ride newRide);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener){
            listener = (OnFragmentInteractionListener) context;
        }else {
            throw new RuntimeException(context.toString() + "must implement OnFragmentInteractionListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.activity_ride_editor, null);

        titleName = view.findViewById((R.id.title_input));
        dateName = view.findViewById((R.id.date_input));
        timeName = view.findViewById((R.id.time_input));
        distanceName = view.findViewById((R.id.distance_input));
        speedName = view.findViewById((R.id.speed_input));
        cadenceName = view.findViewById((R.id.cadence_input));
        commentName = view.findViewById((R.id.comment_input));



        Button confirmButton = view.findViewById(R.id.confirm_button);
        Button cancelButton = view.findViewById(R.id.cancel_button);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder
                .setView(view)
                .setTitle(String.format("Add/Edit %s", ride.getTitle()));
        // populate fields if ride exists
        if(this.isExistingRide()){
            titleName.setText(ride.getTitle(), TextView.BufferType.EDITABLE);
            dateName.setText(ride.getDate(), TextView.BufferType.EDITABLE);
            timeName.setText(ride.getTime());
            distanceName.setText(String.valueOf(ride.getDistance()));
            speedName.setText(String.valueOf(ride.getAverageSpeed()));
            cadenceName.setText(String.valueOf(ride.getAverageCadence()));
            commentName.setText(ride.getComment());

        }
        final AlertDialog dialog = builder.create();

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText[] editTextFields = {titleName, dateName, timeName,
                        distanceName, speedName, cadenceName};

                ArrayList<EditText> inputFields = new ArrayList<>();

                inputFields.addAll(Arrays.asList(editTextFields));

                boolean inputIsValid = verifyRide(inputFields);

                if(inputIsValid){
                    ride.setTitle(titleName.getText().toString());
                    ride.setDate(dateName.getText().toString());
                    ride.setTime(timeName.getText().toString());
                    ride.setDistance(Double.parseDouble(distanceName.getText().toString()));
                    ride.setAverageSpeed(Double.parseDouble(speedName.getText().toString()));
                    ride.setAverageCadence(Integer.parseInt(cadenceName.getText().toString()));
                    ride.setComment(commentName.getText().toString());

                    listener.onOkPressed(ride);

                    dialog.dismiss();
                }


            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        return dialog;

    }

    public boolean verifyRide(ArrayList<EditText> editTexts){
        boolean isValid = true;
        // Iterate EditText Input
        for (int i=0; i < editTexts.size(); i++){
            EditText editText = editTexts.get(i);
            // Check if EditText is empty
            if (editText.getText().toString().isEmpty()){
                editText.setBackgroundColor(Color.RED);  // Red Background
                editText.getBackground().setAlpha(25);  // Slightly Fade
                isValid = false;  // No longer isValid
            }
        }
        return isValid;
    }
}
