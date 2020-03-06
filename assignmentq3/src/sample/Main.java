package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // set the stage layout
        Pane stage = new Pane();
        int width = 500;
        int height = 500;

        // Create the circle object, the 3 points that go on circle, the 3 lines connecting the points and the text that displays the angle
        Circle circle = new Circle(250, 250, 200);
        Circle[] points = new Circle[3];
        Line[] lines = new Line[3];
        Text[] angles = new Text[3];

        // Customize the properties of the circle
        circle.setStroke(Color.BLUE);
        circle.setFill(Color.TRANSPARENT);
        // Add the circle to the stage
        stage.getChildren().add(circle);

        for (int i = 0; i < 3; i++) {
            // initialize shapes
            angles[i] = new Text();
            points[i] = new Circle(0, 0, 5);

            // select the random spots to place the 3 circles
            double angle = Math.random() * 360; // random between 0-1 then multiply by 360
            double x = circle.getCenterX() + circle.getRadius() * Math.cos(Math.toRadians(angle));
            double y = circle.getCenterY() + circle.getRadius() * Math.sin(Math.toRadians(angle));
            points[i].setCenterX(x);
            points[i].setCenterY(y);
        }

        // loop to make the lines
        for (int i = 0; i < 3; i++) {
            int j = (i + 1 >= 3) ? 0 : i + 1;
            lines[i] = new Line(points[i].getCenterX(), points[i].getCenterY(), points[j].getCenterX(), points[j].getCenterY());
        }

        // collect the values for the angle formula
        double a = lineFormula(lines[0]);
        double b = lineFormula(lines[1]);
        double c = lineFormula(lines[2]);

        // calculate the angles
        double A = Math.toDegrees(Math.acos((a * a - b * b - c * c) / (-2 * b * c)));
        double B = Math.toDegrees(Math.acos((b * b - a * a - c * c) / (-2 * a * c)));
        double C = Math.toDegrees(Math.acos((c * c - b * b - a * a) / (-2 * a * b)));

        // set the text with the angles
        angles[0].setText(String.format("%.2f", B));
        angles[1].setText(String.format("%.2f", C));
        angles[2].setText(String.format("%.2f", A));

        // Loop to constantly change the angles everytime the mouse moves
        for (int i = 0; i < 3; i++) {
            // in order to be able to use the index value in the lamba function
            final int i2 = i;
            // lamba function for moving the points when mouse is dragging one of them
            points[i].setOnMouseDragged(e -> {
                // Moves the point
                double newAngle = Math.atan2(e.getY() - circle.getCenterY(), e.getX() - circle.getCenterX());
                double newx = circle.getCenterX() + circle.getRadius() * Math.cos(newAngle);
                double newy = circle.getCenterY() + circle.getRadius() * Math.sin(newAngle);
                points[i2].setCenterX(newx);
                points[i2].setCenterY(newy);

                // Updates the line
                for (int j = 0; j < 3; j++) {
                    // if statement for which points get merged together so no line is made to the same point
                    int i3 = (j + 1 >= 3) ? 0 : j + 1;
                    // make the new lines
                    lines[j].setStartX(points[j].getCenterX());
                    lines[j].setStartY(points[j].getCenterY());
                    lines[j].setEndX(points[i3].getCenterX());
                    lines[j].setEndY(points[i3].getCenterY());
                    angles[j].setX(points[j].getCenterX() + 5);
                    angles[j].setY(points[j].getCenterY() - 5);
                }
                // collect the values for the angle formula
                double newa = lineFormula(lines[0]);
                double newb = lineFormula(lines[1]);
                double newc = lineFormula(lines[2]);

                // calculate the angles
                double newA = Math.toDegrees(Math.acos((newa * newa - newb * newb - newc * newc) / (-2 * newb * newc)));
                double newB = Math.toDegrees(Math.acos((newb * newb - newa * newa - newc * newc) / (-2 * newa * newc)));
                double newC = Math.toDegrees(Math.acos((newc * newc - newb * newb - newa * newa) / (-2 * newa * newb)));

                // set the text with the angles
                angles[0].setText(String.format("%.2f", newB));
                angles[1].setText(String.format("%.2f", newC));
                angles[2].setText(String.format("%.2f", newA));
            });
        }

        // Add everything to the stage
        stage.getChildren().addAll(lines);
        stage.getChildren().addAll(angles);
        stage.getChildren().addAll(points);
        primaryStage.setScene(new Scene(stage, width, height));
        primaryStage.setTitle("Question 3");
        primaryStage.show();
    }

    // formula to collect the line distance in order to later be able to calculate the angle
    private static double lineFormula(Line line) {
        // collect the numbers for the formula
        double x1 = line.getStartX();
        double x2 = line.getEndX();
        double y1 = line.getStartY();
        double y2 = line.getEndY();

        // plug in the values into the formula and return the line distance
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
