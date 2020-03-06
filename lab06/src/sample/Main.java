package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {

    private static double[] avgHousingPricesByYear = {
            247381.0,264171.4,287715.3,294736.1,
            308431.4,322635.9,340253.0,363153.7
    };
    private static double[] avgCommercialPricesByYear = {
            1121585.3,1219479.5,1246354.2,1295364.8,
            1335932.6,1472362.0,1583521.9,1613246.3
    };
    private static String[] ageGroups = {
            "18-25", "26-35", "36-45", "46-55", "56-65", "65+"
    };
    private static int[] purchasesByAgeGroup = {
            648, 1021, 2453, 3173, 1868, 2247
    };
    private static Color[] pieColours = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE,
            Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
    };
    private Canvas canvas;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("lab6");
        Group root = new Group();
        this.canvas = new Canvas();
        this.canvas.widthProperty().bind(primaryStage.widthProperty());
        this.canvas.heightProperty().bind(primaryStage.heightProperty());
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();

        // draw barchart
        GraphicsContext graphics = canvas.getGraphicsContext2D();

        for (int i = 0; i < 8; i++) {
            double val1 = avgHousingPricesByYear[i];
            double val2 = avgCommercialPricesByYear[i];
            double x = 50 + 50*i;

            // Draw the elements in the series
            double height1 = ((val1 - 247381.0 + 500000) / (1613246.3 - 247381.0)) * 325;
            double height2 = ((val2 - 247381.0 + 500000) / (1613246.3 - 247381.0)) * 325;
            graphics.setFill(Color.RED);
            graphics.strokeRect(x, 50 + 325 - height1, 15, height1);
            graphics.fillRect(x, 50 + 325 - height1, 15, height1);
            graphics.setFill(Color.BLUE);
            graphics.strokeRect(x+15, 50 + 325 - height2, 15, height2);
            graphics.fillRect(x+15, 50 + 325 - height2, 15, height2);
            x += 160;
        }

        // draw piechart
        int total =0;
        double startAngle = 0;
        double endAngle;
        for (int purchase : purchasesByAgeGroup) {
            total += purchase;
        }
        double arcs = Math.pow(total,-1)*360;
        System.out.println(purchasesByAgeGroup.length);
        for(int i = 0; i < purchasesByAgeGroup.length;i++){
            graphics.setFill(pieColours[i]);
            endAngle = (purchasesByAgeGroup[i] * arcs);
            System.out.println("Start Angle: " + startAngle + " End Angle: " + endAngle + " Colour: " + graphics.getFill());
            graphics.fillArc(500, 50, 325, 325, startAngle, endAngle, ArcType.ROUND);
            startAngle += endAngle;
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
