/**
 * UserInterfaceFragment is a subclass of UserInterface specialized for the RideEditorFragment
 * Class
 *
 * Acknowledgements:
 *  Setting background colors for EditTexts based on state: https://stackoverflow.com/a/18936728
 * */

package com.example.kebbi_ridebook.userinterface;

import android.app.AlertDialog;
import android.graphics.Color;
import android.view.View;
import android.widget.EditText;

import com.example.kebbi_ridebook.Ride;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class UserInterfaceFragment extends UserInterface {


    private boolean rideExists;
    private boolean valid;

    private View view;

    private AlertDialog dialog;

    private EditText[] editTextFields;

    public UserInterfaceFragment(Ride ride, boolean rideExists){
        this.setRide(ride);
        this.setRideExists(rideExists);
    }

    public boolean isRideExists() {
        return rideExists;
    }

    public void setRideExists(boolean rideExists) {
        this.rideExists = rideExists;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public AlertDialog getDialog() {
        return dialog;
    }

    public void setDialog(AlertDialog dialog) {
        this.dialog = dialog;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public EditText[] getEditTextFields() {
        return editTextFields;
    }

    public void validateRide(EditText[] editTextFields) {
        this.editTextFields = editTextFields;

        ArrayList<EditText> inputFields = new ArrayList<>();

        inputFields.addAll(Arrays.asList(editTextFields));
        
       this.validate(inputFields);
    }

    private void validate(ArrayList<EditText> editTexts) {

        this.setValid(true);

        this.verifyDate(editTexts.get(1));

        this.clearColors(editTexts);

        this.verifyPatterns(editTexts);
    }

    private void verifyDate(EditText editText) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);

        try{
            dateFormat.parse(editText.getText().toString());
            editText.setBackgroundColor(Color.GREEN);
            editText.getBackground().setAlpha(25);
        } catch (ParseException e) {
            this.invalidate(editText);
        }
    }

    private void verifyPatterns(ArrayList<EditText> editTexts) {
        String[] patterns = {"^.{1,20}$",
                "\\d{4}-[01]\\d-[0-3]\\d",
                "^(0[0-9]|1[0-9]|2[0-3]|[0-9]):[0-5][0-9]$",
                "^[1-9]\\d*(\\.\\d+)?$",
                "^[1-9]\\d*(\\.\\d+)?$",
                "^[0-9]*[1-9][0-9]*$",
                "^.{0,20}$"
        };

        for (int i=0; i < editTexts.size(); i++){
            // Get current parameter
            EditText editText = editTexts.get(i);
            // Verify Text with Pattern
            if (this.isInvalid(editText.getText().toString(), patterns[i])){
                this.invalidate(editText);
            }else{
                editText.setBackgroundColor(Color.GREEN);
                editText.getBackground().setAlpha(25);
            }
        }
    }

    private void invalidate(EditText editText) {
        editText.setBackgroundColor(Color.RED);  // Red Background
        editText.getBackground().setAlpha(25);  // Slightly Fade
        this.setValid(false);  // No longer Valid ride
    }

    private boolean isInvalid(String givenString, String pattern) {
        return !givenString.matches(pattern);
    }

    private  void clearColors(ArrayList<EditText> editTexts){
        for (int i=0; i < editTexts.size(); i++){
            // Get current parameter
            EditText editText = editTexts.get(i);
            editText.setBackgroundColor(Color.TRANSPARENT);
        }
    }
}
