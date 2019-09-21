package RideAttributes;

public class AverageSpeed extends RideAttribute {
    public AverageSpeed(String input) {
        super(input);

        this.setAttributePattern("^[1-9]\\d*(\\.\\d+)?$");

    }

    @Override
    public void applyInput() {
        this.setValue(this.getInput());

        this.setAttributeTextView(String.format("Average Speed: %s km/h", this.getValue()));
    }
}
