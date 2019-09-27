package com.example.kebbi_ridebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class RideList extends ArrayAdapter<Ride> {
    private ArrayList<Ride> rides;
    private Context context;

    public RideList(Context context, ArrayList<Ride> rides){
        super(context, 0, rides);
        this.rides = rides;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent, false);
        }

        // Define ride
        Ride ride = rides.get(position);

        // Get Text View of Each item
        TextView title = view.findViewById(R.id.title_textview);
        TextView date = view.findViewById(R.id.date_textview);
        TextView time = view.findViewById(R.id.time_textview);
        TextView distance = view.findViewById(R.id.distance_textview);

        title.setText(ride.getTitle());

        // Set text to string distance
        distance.setText(String.valueOf(ride.getDistance()));

        // Set Date
        date.setText(ride.getDate());

        // Set Time
        time.setText(ride.getTime());

        return view;
    }
}
