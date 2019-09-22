package RideAttributes;

public class Distance extends RideAttribute {
    private float value;

    public Distance(String input) {
        super(input);

        this.setAttributePattern("^[1-9]\\d*(\\.\\d+)?$");

        this.verifyInput();

    }

    @Override
    public void applyInput() {
        this.setValue(this.getInput());

        this.setAttributeTextView(String.format("Time: %s km", this.getValue()));
    }
}
