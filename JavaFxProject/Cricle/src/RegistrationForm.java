import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegistrationForm extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("User Registration");

        Label nameLabel = new Label("Name:");
        Label dobLabel = new Label("Date of Birth:");
        Label favColorLabel = new Label("Favorite Color:");
        TextField nameTextField = new TextField();
        DatePicker dobDataValue = new DatePicker();
        ColorPicker favColorDataValue = new ColorPicker();
        Button submitButton = new Button("Submit Data");
        Button cancelButton = new Button("Cancel");

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Name: " + nameTextField.getText());
                System.out.println("Date of Birth: " + dobDataValue.getValue());
                System.out.println("Favorite Color: " + favColorDataValue.getValue());
            }
        });

        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
          public void handle (ActionEvent event) {
                nameTextField.setText(null);
                dobDataValue.setValue(null);
                favColorDataValue.setValue(null);
          }  
        });

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(30));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameTextField, 1, 0);
        gridPane.add(dobLabel, 0, 1);
        gridPane.add(dobDataValue, 1, 1);
        gridPane.add(favColorLabel, 0, 2);
        gridPane.add(favColorDataValue, 1, 2);
        gridPane.add(submitButton, 1, 4);
        gridPane.add(cancelButton, 2, 4);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(gridPane);
        Scene scene = new Scene(vbox, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
