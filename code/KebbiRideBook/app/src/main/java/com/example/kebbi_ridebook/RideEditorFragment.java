package com.example.kebbi_ridebook;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.kebbi_ridebook.userinterface.UserInterfaceFragment;

public class RideEditorFragment extends DialogFragment {

    private UserInterfaceFragment uiFragment;

    private OnFragmentInteractionListener listener;

    private EditText titleName;
    private EditText dateName;
    private EditText timeName;
    private EditText distanceName;
    private EditText speedName;
    private EditText cadenceName;
    private EditText commentName;



    // Constructor for Adding New Rides
    public RideEditorFragment(){
        this.uiFragment = new UserInterfaceFragment(new Ride(), false);
    }

    // Constructor for Editing Existing Rides
    public RideEditorFragment(Ride ride){
        this.uiFragment = new UserInterfaceFragment(ride,true);

    }

    public interface OnFragmentInteractionListener {
        void onOkPressed(Ride newRide);
        void onCancelPressed();
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
        this.uiFragment.setView(LayoutInflater.from(getActivity()).inflate(R.layout.activity_ride_editor, null));

        this.initializeEditTexts();

        Button confirmButton = this.uiFragment.getView().findViewById(R.id.confirm_button);
        Button cancelButton = this.uiFragment.getView().findViewById(R.id.cancel_button);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder
                .setView(this.uiFragment.getView())
                .setTitle(String.format("Add/Edit %s", this.uiFragment.getRide().getTitle()));

        if(this.uiFragment.isRideExists()){
            this.populateFields();
        }

        uiFragment.setDialog(builder.create());

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uiFragment.validateRide(new EditText[]{titleName, dateName, timeName,
                        distanceName, speedName, cadenceName, commentName});


                if(uiFragment.isValid()){
                    createRide();

                    listener.onOkPressed(uiFragment.getRide());

                    uiFragment.getDialog().dismiss();
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCancelPressed();
                uiFragment.getDialog().dismiss();
            }
        });

        return uiFragment.getDialog();

    }

    // Helper Functions
    private void createRide() {
        uiFragment.getRide().setTitle(titleName.getText().toString());
        uiFragment.getRide().setDate(dateName.getText().toString());
        uiFragment.getRide().setTime(timeName.getText().toString());
        uiFragment.getRide().setDistance(Double.parseDouble(distanceName.getText().toString()));
        uiFragment.getRide().setAverageSpeed(Double.parseDouble(speedName.getText().toString()));
        uiFragment.getRide().setAverageCadence(Integer.parseInt(cadenceName.getText().toString()));
        uiFragment.getRide().setComment(commentName.getText().toString());
    }

    private void populateFields() {
        titleName.setText(uiFragment.getRide().getTitle());
        dateName.setText(uiFragment.getRide().getDate());
        timeName.setText(uiFragment.getRide().getTime());
        distanceName.setText(String.valueOf(uiFragment.getRide().getDistance()));
        speedName.setText(String.valueOf(uiFragment.getRide().getAverageSpeed()));
        cadenceName.setText(String.valueOf(uiFragment.getRide().getAverageCadence()));
        commentName.setText(uiFragment.getRide().getComment());
    }

    private void initializeEditTexts() {
        titleName = this.uiFragment.getView().findViewById((R.id.title_input));
        dateName = this.uiFragment.getView().findViewById((R.id.date_input));
        timeName = this.uiFragment.getView().findViewById((R.id.time_input));
        distanceName = this.uiFragment.getView().findViewById((R.id.distance_input));
        speedName = this.uiFragment.getView().findViewById((R.id.speed_input));
        cadenceName = this.uiFragment.getView().findViewById((R.id.cadence_input));
        commentName = this.uiFragment.getView().findViewById((R.id.comment_input));
    }

}
