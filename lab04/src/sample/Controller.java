package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.time.format.DateTimeFormatter;

public class Controller {

    public TextField username;
    public PasswordField password;
    public DatePicker birthday;
    public TextField name;
    public TextField email;
    public TextField phone;

    public void pressButton(ActionEvent event) {
        String usernameText = username.getText();
        String passwordText = password.getText();
        String nameText = name.getText();
        String emailText = email.getText();
        String phoneText = phone.getText().replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
        String birthdayText = birthday.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("Username: " + usernameText);
        System.out.println("Password: " + passwordText);
        System.out.println("Full name: " + nameText);
        System.out.println("E-Mail: " + emailText);
        System.out.println("Phone #: " + phoneText);
        System.out.println("Date of birth: " + birthdayText);
        username.clear();
        password.clear();
        birthday.getEditor().clear();
        name.clear();
        email.clear();
        phone.clear();
    }
}
