package com.example.kebbi_ridebook.RideAttributes;

public class Time extends RideAttribute {


    public Time(String input) {
        super(input);

        this.setAttributePattern("^(0[0-9]|1[0-9]|2[0-3]|[0-9]):[0-5][0-9]$");

        this.verifyInput();

    }

    @Override
    public void modifyInput(String newInput) {

    }

    @Override
    public void applyInput() {
        this.setValue(this.getInput());

        this.setAttributeTextView(String.format("Time: %s", this.getValue()));
    }
}
