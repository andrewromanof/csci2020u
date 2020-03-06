package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    // declare the textfield properties
    public TextField Amount;
    public TextField Years;
    public TextField Rate;
    public TextField future;
    public Button calculate;

    // function for when button is pressed
    public void Calculate(ActionEvent event) {
        // Collect values from the textfield
        double amount = Double.parseDouble(Amount.getText());
        double rate = Double.parseDouble(Rate.getText());
        double years = Double.parseDouble(Years.getText());

        // use formula to calculate future value
        double futureV = amount * Math.pow((1 + ((rate/12) / 100)), years*12);

        // Display answer
        future.setText(Double.toString((futureV)));
    }
}
