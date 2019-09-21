package RideAttributes;

public class Title extends RideAttribute {
    public Title(String input) {
        super(input);

        this.setAttributePattern("^.{1,20}$");
    }

    @Override
    public void applyInput() {
        this.setValue(this.getInput());

        this.setAttributeTextView(this.getValue());
    }
}