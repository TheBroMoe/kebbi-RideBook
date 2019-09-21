package RideAttributes;

public class Comment extends RideAttribute {
    public Comment(String input) {
        super(input);

        this.setAttributePattern("^.{0,20}$");
    }

    @Override
    public void applyInput() {
        this.setValue(this.getInput());

        this.setAttributeTextView(this.getValue());
    }
}
