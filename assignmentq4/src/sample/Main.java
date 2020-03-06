package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    Pane pane = new Pane();
    TextField text = new TextField();
    VBox box = new VBox();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Label fileName = new Label("Filename:", text);
        fileName.setContentDisplay(ContentDisplay.RIGHT);
        Button btView = new Button("View");

        HBox hBox = new HBox(fileName, btView);

        box.getChildren().addAll(pane, hBox);
        Scene scene = new Scene(box);
        primaryStage.setScene(scene);
        btView.setOnAction(e-> {
            createHistogram();
            primaryStage.sizeToScene();

        });
        primaryStage.show();
    }

    public void createHistogram() {

    }


    public static void main(String[] args) {
        launch(args);
    }
}
