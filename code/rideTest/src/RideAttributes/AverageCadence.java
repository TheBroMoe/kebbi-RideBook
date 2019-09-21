package RideAttributes;

public class AverageCadence extends RideAttribute {
    public AverageCadence(String input) {
        super(input);

        this.setAttributePattern("^[0-9]*[1-9][0-9]*$");

    }

    @Override
    public void applyInput() {
        this.setValue(this.getInput());

        this.setAttributeTextView(String.format("Average Cadence: %s revs/min", this.getValue()));
    }
}
