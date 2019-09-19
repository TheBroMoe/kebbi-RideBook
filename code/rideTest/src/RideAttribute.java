/**
 * The RideAttribute Class implements an abstraction for
 * ride attributes when a user creates a ride
 *
 * @author  Mohammad Kebbi
 * @version 1.0
 * @since   2019-9-18
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class RideAttribute {

    // Class Attributes
    protected String input;  // Input from user
    protected String value;  // string stored to represent attribute
    protected String attributePattern;  // Regex pattern used to verify proper input



    protected String attributePatternTV;  // Text displayed to TextView in application
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

    public void getValue(String value) { return value}

    public void setValue(String value) {
        this.value = value;
    }

    public String getAttributePattern() {
        return attributePattern;
    }

    public void setAttributePattern(String attributePattern) {
        this.attributePattern = attributePattern;
    }

    public String getAttributePatternTV() {
        return attributePatternTV;
    }

    public void setAttributePatternTV(String attributePatternTV) {
        this.attributePatternTV = attributePatternTV;
    }

    public boolean isValidInput() {
        return validInput;
    }

    public void setValidInput(boolean validInput) {
        this.validInput = validInput;
    }

    // Abstract Methods
    public abstract void verifyInput();
    public abstract void applyInput();
    public abstract void modifyInput(String newInput);

}
