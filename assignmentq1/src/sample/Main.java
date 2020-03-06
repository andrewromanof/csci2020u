package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // create new class instance
        DisplayCards cards = new DisplayCards();
        // set the size of the images
        cards.setSize(500, 500);
        // make them visible
        cards.setVisible((true));
    }


    public static void main(String[] args) {
        launch(args);
    }
}

// New class called DisplayCards to display the cards since Main can't extend Application and JFrame
class DisplayCards extends JFrame {

    public DisplayCards() {
        //setting a layout: GridLayout with 1 row, 3 columns
        setLayout(new GridLayout(1, 3, 10, 10));

        //initializing the array with an icon from the image folder
        ImageIcon[] icon = new ImageIcon[52];
        for (int i = 1; i < 52; i++) {
            icon[i] = new ImageIcon("C:\\Users\\andre\\Desktop\\java\\csci2020\\assignment\\src\\sample\\" + (i) + ".png");
        }

        //generating the random numbers
        int num1 = (int) (Math.random() * 52);
        int num2 = (int) (Math.random() * 52);
        int num3 = (int) (Math.random() * 52);

        //adding the random image to JLabel
        add(new JLabel(icon[num1]));
        add(new JLabel(icon[num2]));
        add(new JLabel(icon[num3]));
    }
}