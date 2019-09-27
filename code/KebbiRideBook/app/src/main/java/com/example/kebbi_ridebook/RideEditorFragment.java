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

    // Constructor for Adding New Rides
//    public RideEditorFragment(){this.ride = new Ride();}
//
//    // Constructor for Editing Existing Rides
//    public RideEditorFragment(Ride ride){this.ride = ride;}

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
                .setTitle("New Ride");

        final AlertDialog dialog = builder.create();

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleName.getText().toString();
                String date = dateName.getText().toString();
                String time = timeName.getText().toString();
                double distance = Double.parseDouble(distanceName.getText().toString());
                double speed = Double.parseDouble(speedName.getText().toString());
                int cadence = Integer.parseInt(cadenceName.getText().toString());
                String comment = commentName.getText().toString();
                listener.onOkPressed(new Ride(title, date, time, distance, speed, cadence, comment));

                dialog.dismiss();

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
}
