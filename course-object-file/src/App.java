import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.plaf.metal.MetalIconFactory.FileIcon16;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    public void start (Stage primaryStage) {
        Label courseNumberLabel = new Label("Course Number");
        Label courseTitleLabel = new Label("course Title");
        Label creditHourLabel = new Label("Credit Hour");
        Label printLabel = new Label(" ");

        TextField courseNumberText = new TextField();
        TextField courseTitleText = new TextField();
        TextField creditHourText = new TextField();

        Button regButton = new Button("Save");
        Button printButton = new Button("Print");


        HBox hbox1 = new HBox();
        hbox1.getChildren().addAll(courseNumberLabel, courseNumberText, courseTitleLabel, courseTitleText);
        hbox1.setPadding(new Insets(0, 0, 10, 10));
        hbox1.setSpacing(10);

        HBox hbox2 = new HBox();
        hbox2.getChildren().addAll(creditHourLabel, creditHourText, regButton);
        hbox2.setPadding(new Insets(0, 0, 10, 10));
        hbox2.setSpacing(10);

        HBox hbox3 = new HBox();
        hbox3.getChildren().addAll(printButton, printLabel);
        hbox3.setPadding(new Insets(0, 0, 10, 10));
        hbox3.setSpacing(10);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(hbox1, hbox2);
        vbox.setPadding(new Insets(0, 0, 10, 10));
        vbox.setSpacing(10);

        regButton.setOnAction(e -> {
            String courseNumber = courseNumberText.getText();
            String creditHour = creditHourText.getText();
            String courseTitle = courseTitleText.getText();

            Course course = new Course(courseTitle, courseNumber, creditHour);
            try {
                writeIntoFile(course);
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        });

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(vbox);

        Scene scene = new Scene(stackPane, 300, 700);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void writeIntoFile (Course course) throws ClassNotFoundException {
        File file = new File("data.txt");
        try (FileOutputStream fout = new FileOutputStream(file)) {
            ObjectOutputStream objOut = new ObjectOutputStream(fout);
            objOut.writeObject(course);
            objOut.close();
            readIntoFile(file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Course readIntoFile (File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fin =  new FileInputStream(file);
        try (ObjectInputStream objIn = new ObjectInputStream(fin)) {
            return (Course) objIn.readObject();
        } 
    }

    
    public static void main(String[] args) throws Exception {
        launch(args);
        File file = new File("data.txt");
        Course course;
        course = readIntoFile(file);
        // course.toString;
    }
}
