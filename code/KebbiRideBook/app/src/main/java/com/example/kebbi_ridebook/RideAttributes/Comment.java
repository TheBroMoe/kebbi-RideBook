package com.example.kebbi_ridebook.RideAttributes;

public class Comment extends RideAttribute {
    public Comment(String input) {
        super(input);

        this.setAttributePattern("^.{0,20}$");

        this.verifyInput();

    }

    @Override
    public void applyInput() {
        this.setValue(this.getInput());

        this.setAttributeTextView(this.getValue());
    }
}
