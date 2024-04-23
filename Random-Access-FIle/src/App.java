import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.RandomAccessFile;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        String filePath = "personData.dat";

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label addressLabel = new Label("Address:");
        TextField addressField = new TextField();

        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();

        Label sexLabel = new Label("Sex:");
        ComboBox<String> sexComboBox = new ComboBox<>();
        sexComboBox.getItems().addAll("Male", "Female");

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(event -> {
            String name = nameField.getText();
            String address = addressField.getText();
            int age = Integer.parseInt(ageField.getText());
            char sex = sexComboBox.getValue().charAt(0);

            writeToFile(filePath, name, address, age, sex);

            nameField.clear();
            addressField.clear();
            ageField.clear();
            sexComboBox.getSelectionModel().clearSelection();
        });

        Button retrieveButton = new Button("Retrieve Data");
        retrieveButton.setOnAction(event -> {
            readFromFile(filePath);
        });

        VBox root = new VBox(10);
        root.getChildren().addAll(nameLabel, nameField, addressLabel, addressField, ageLabel, ageField, sexLabel, sexComboBox, submitButton, retrieveButton);

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setTitle("Person Data Random Access File");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Write data to the Random Access File
    private static void writeToFile(String filePath, String name, String address, int age, char sex) {
        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {
            writeString(file, name, 30);
            writeString(file, address, 30);
            file.writeInt(age);
            file.writeChar(sex);
            System.out.println("Data has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read data from the Random Access File
    private static void readFromFile(String filePath) {
        try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
            System.out.println("Reading from the file:");
            System.out.println("Name: " + readString(file, 30).trim());
            System.out.println("Address: " + readString(file, 30).trim());
            System.out.println("Age: " + file.readInt());
            System.out.println("Sex: " + file.readChar());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to write string to the Random Access File
    private static void writeString(RandomAccessFile file, String data, int length) throws IOException {
        file.writeBytes(String.format("%-" + length + "s", data));
    }

    // Method to read string from the Random Access File
    private static String readString(RandomAccessFile file, int length) throws IOException {
        byte[] bytes = new byte[length];
        file.readFully(bytes);
        return new String(bytes);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
