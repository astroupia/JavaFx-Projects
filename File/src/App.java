import java.io.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    public void start(Stage primaryStage) {
        Label content = new Label("Enter Content");
        TextField field = new TextField();
        Button insertButton = new Button("Insert Button");

        insertButton.setOnAction(e -> {
            File file = new File("./file.txt");
            try (FileWriter writeFile = new FileWriter(file)) {
                writeFile.write(field.getText());
                writeFile.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        VBox vBox = new VBox(30);
        vBox.getChildren().addAll(content, field, insertButton);

        Scene scene =  new Scene(vBox, 300, 300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
