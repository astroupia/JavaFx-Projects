import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    public void start (Stage primaryStage) {
        Label nameLabel = new Label("Name");
        Label idLabel = new Label("Id Number");
        Label addressLabel = new Label("Address");

        TextField nameText = new TextField();
        TextField idText = new TextField();
        TextField addressText = new TextField();

        Button regButton = new Button();

        VBox vbox1 = new VBox();
        vbox1.getChildren().addAll(nameLabel, nameText, idLabel, idText);

        VBox vbox2 = new VBox();
        vbox2.getChildren().addAll(addressLabel, addressText, regButton);

        regButton.setOnAction(e -> {
            String name = nameText.getText();
            String address = addressText.getText();
            String id = idText.getText();

            User user = new User(id, name, address);
            writeIntoFIle(user);

        });

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(vbox1, vbox2);

        Scene scene = new Scene(stackPane, 300, 700);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void writeIntoFIle (User user) {
        File file = new File("data.txt");

    }
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
