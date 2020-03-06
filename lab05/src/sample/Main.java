package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    TableView<StudentRecord> table;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Lab 05");

        TableColumn<StudentRecord, String> studentIDColumn = new TableColumn<>("SID");
        studentIDColumn.setMinWidth(200);
        studentIDColumn.setCellValueFactory(new PropertyValueFactory<>("StudentID"));

        TableColumn<StudentRecord, Double> AssignmentsColumn = new TableColumn<>("Assignments");
        AssignmentsColumn.setMinWidth(200);
        AssignmentsColumn.setCellValueFactory(new PropertyValueFactory<>("Assignments"));

        TableColumn<StudentRecord, Double> MidtermColumn = new TableColumn<>("Midterm");
        MidtermColumn.setMinWidth(200);
        MidtermColumn.setCellValueFactory(new PropertyValueFactory<>("Midterm"));

        TableColumn<StudentRecord, Double> ExamColumn = new TableColumn<>("Final Exam");
        ExamColumn.setMinWidth(200);
        ExamColumn.setCellValueFactory(new PropertyValueFactory<>("Exam"));

        TableColumn<StudentRecord, Double> FinalColumn = new TableColumn<>("Final Mark");
        FinalColumn.setMinWidth(200);
        FinalColumn.setCellValueFactory(new PropertyValueFactory<>("Final"));

        TableColumn<StudentRecord, String> GradeColumn = new TableColumn<>("Letter Grade");
        GradeColumn.setMinWidth(200);
        GradeColumn.setCellValueFactory(new PropertyValueFactory<>("Grade"));

        table = new TableView<>();
        table.setItems(getAllMarks());
        table.getColumns().addAll(studentIDColumn, AssignmentsColumn, MidtermColumn, ExamColumn, FinalColumn, GradeColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static ObservableList<StudentRecord> getAllMarks() {
        ObservableList<StudentRecord> marks = FXCollections.observableArrayList();

        // Student ID, Assignments, Midterm, Final exam
        marks.add(new StudentRecord("100100100", 75.0f, 68.0f, 54.25f));
        marks.add(new StudentRecord("100100101", 70.0f, 69.25f, 51.5f));
        marks.add(new StudentRecord("100100102", 100.0f, 97.0f, 92.5f));
        marks.add(new StudentRecord("100100103", 90.0f, 88.5f, 68.75f));
        marks.add(new StudentRecord("100100104", 72.25f, 74.75f, 58.25f));
        marks.add(new StudentRecord("100100105", 85.0f, 56.0f, 62.5f));
        marks.add(new StudentRecord("100100106", 70.0f, 66.5f, 61.75f));
        marks.add(new StudentRecord("100100107", 55.0f, 47.0f, 50.5f));
        marks.add(new StudentRecord("100100108", 40.0f, 32.5f, 27.75f));
        marks.add(new StudentRecord("100100109", 82.5f, 77.0f, 74.25f));
        return marks;
    }
}
