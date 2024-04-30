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
        Label nameLabel = new Label("Name");
        Label idLabel = new Label("Id Number");
        Label addressLabel = new Label("Address");

        TextField nameText = new TextField();
        TextField idText = new TextField();
        TextField addressText = new TextField();

        Button regButton = new Button("Register");

        HBox hbox1 = new HBox();
        hbox1.getChildren().addAll(nameLabel, nameText, idLabel, idText);
        hbox1.setPadding(new Insets(0, 0, 10, 10));
        hbox1.setSpacing(10);

        HBox hbox2 = new HBox();
        hbox2.getChildren().addAll(addressLabel, addressText, regButton);
        hbox2.setPadding(new Insets(0, 0, 10, 10));
        hbox2.setSpacing(10);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(hbox1, hbox2);
        vbox.setPadding(new Insets(0, 0, 10, 10));
        vbox.setSpacing(10);

        regButton.setOnAction(e -> {
            String name = nameText.getText();
            String address = addressText.getText();
            String id = idText.getText();

            User user = new User(id, name, address);
            try {
                writeIntoFile(user);
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
    public static void writeIntoFile (User user) throws ClassNotFoundException {
        File file = new File("data.txt");
        try (FileOutputStream fout = new FileOutputStream(file)) {
            ObjectOutputStream objOut = new ObjectOutputStream(fout);
            objOut.writeObject(user);
            objOut.close();
            readIntoFile(file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static User readIntoFile (File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fin =  new FileInputStream(file);
        ObjectInputStream objIn = new ObjectInputStream(fin);
        return (User) objIn.readObject(); 
    }

    
    public static void main(String[] args) throws Exception {
        launch(args);
        File file = new File("data.txt");
        User user;
        user = readIntoFile(file);
        user.toString;
    }
}
