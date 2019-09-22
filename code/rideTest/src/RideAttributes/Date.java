package RideAttributes; /**
 * The RideAttributes.Date Class implements an abstraction for
 * ride attributes when a user creates a ride
 *
 * @author  Mohammad Kebbi
 * @version 1.0
 * @since   2019-9-18
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Date  extends  RideAttribute{
    private SimpleDateFormat dateFormat;
    public Date(String input){
        super(input);

        this.setAttributePattern("\\d{4}-[01]\\d-[0-3]\\d");

        this.initialize_dateFormat();

        this.verifyInput();

    }

    private  void initialize_dateFormat(){
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.dateFormat.setLenient(false);
    }

    @Override
    public void verifyInput() {
        if (this.input == null || !this.input.matches(this.getAttributePattern()))
            this.setValidInput(false);
        try {
            dateFormat.parse(this.input);
            this.setValidInput(true);
        } catch (ParseException ex) {
            this.setValidInput(false);
        }
    }

    @Override
    public void applyInput() {
        this.setValue(this.getInput());

        this.setAttributeTextView(String.format("Date: %s", this.getValue()));

    }

}
