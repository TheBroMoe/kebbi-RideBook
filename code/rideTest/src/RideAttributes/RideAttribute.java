package RideAttributes;

/**
 * The RideAttributes.RideAttribute Class implements an abstraction for
 * ride attributes when a user creates a ride
 *
 * @author  Mohammad Kebbi
 * @version 1.0
 * @since   2019-9-18
 */

public abstract class RideAttribute {

    // Class Attributes
    protected String input;
    protected String value;  // string stored to represent attribute
    protected String attributePattern;  // Regex pattern used to verify proper input
    protected String attributeTextView;  // Text displayed to TextView in application

    protected boolean validInput;  // Boolean to identify correct input

    // Constructor
    public RideAttribute(String input){
        this.input = input;
    }

    // Getters and Setters
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getValue() { return value;}

    public void setValue(String value) {
        this.value = value;
    }

    public String getAttributePattern() {
        return attributePattern;
    }

    public void setAttributePattern(String attributePattern) {
        this.attributePattern = attributePattern;
    }

    public String getAttributeTextView() {
        return attributeTextView;
    }

    public void setAttributeTextView(String attributeTextView) {
        this.attributeTextView = attributeTextView;
    }

    public boolean isValidInput() {
        return validInput;
    }

    public void setValidInput(boolean validInput) {
        this.validInput = validInput;
    }

    public void verifyInput(){
        if (this.input == null || !this.input.matches(this.getAttributePattern()))
            this.setValidInput(false);
        else{
            this.setValidInput(true);
        }
    }

    public void modifyInput(String newInput){
        this.setInput(newInput);

        this.verifyInput();

        if (this.isValidInput()){
            this.applyInput();
        }
    }

    // Abstract Methods

    public abstract void applyInput();

}
