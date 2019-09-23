package com.example.kebbi_ridebook.RideAttributes;

public class Title extends RideAttribute {
    public Title(String input) {
        super(input);

        this.setAttributePattern("^.{1,20}$");

        this.verifyInput();

    }

    @Override
    public void applyInput() {
        this.setValue(this.getInput());

        this.setAttributeTextView(this.getValue());
    }
}
