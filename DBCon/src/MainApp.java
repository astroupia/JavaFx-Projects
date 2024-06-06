import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.*;

public class MainApp extends Application {

    private Connection connection;

    @Override
    public void start(Stage primaryStage) {
        // Database connection
        connectToDatabase();

        // Form fields
        TextField nameField = new TextField();
        DatePicker dobPicker = new DatePicker();
        ToggleGroup sexGroup = new ToggleGroup();
        RadioButton maleRadio = new RadioButton("Male");
        maleRadio.setToggleGroup(sexGroup);
        RadioButton femaleRadio = new RadioButton("Female");
        femaleRadio.setToggleGroup(sexGroup);
        TextField occupationField = new TextField();
        ComboBox<Integer> experienceBox = new ComboBox<>();
        for (int i = 0; i <= 50; i++) {
            experienceBox.getItems().add(i);
        }

        // Submit button
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            String name = nameField.getText();
            String dob = dobPicker.getValue().toString();
            String sex = ((RadioButton) sexGroup.getSelectedToggle()).getText();
            String occupation = occupationField.getText();
            int experience = experienceBox.getValue();

            insertData(name, dob, sex, occupation, experience);
        });

        // View List Card button
        Button viewListCardButton = new Button("View List Card");
        viewListCardButton.setOnAction(e -> showPersonCards());

        // Layout setup
        VBox formBox = new VBox(10, 
                new Label("Name:"), nameField,
                new Label("Date of Birth:"), dobPicker,
                new Label("Sex:"), maleRadio, femaleRadio,
                new Label("Occupation:"), occupationField,
                new Label("Experience:"), experienceBox,
                submitButton, viewListCardButton);
        formBox.setPadding(new Insets(20));

        StackPane root = new StackPane(formBox);
        Scene scene = new Scene(root, 400, 400);

        primaryStage.setTitle("Person Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/person_db", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertData(String name, String dob, String sex, String occupation, int experience) {
        String query = "INSERT INTO persons (name, dob, sex, occupation, experience) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setString(2, dob);
            pstmt.setString(3, sex);
            pstmt.setString(4, occupation);
            pstmt.setInt(5, experience);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showPersonCards() {
        Stage listStage = new Stage();
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10));

        String query = "SELECT name, dob, sex, occupation, experience FROM persons";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String name = rs.getString("name");
                String dob = rs.getString("dob");
                String sex = rs.getString("sex");
                String occupation = rs.getString("occupation");
                int experience = rs.getInt("experience");

                HBox hBox = new HBox(10, new Label("Name: " + name), new Label("DOB: " + dob), new Label("Sex: " + sex), new Label("Occupation: " + occupation), new Label("Experience: " + experience + " years"));
                vBox.getChildren().add(hBox);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        StackPane root = new StackPane(vBox);
        Scene scene = new Scene(root, 600, 400);
        listStage.setScene(scene);
        listStage.setTitle("Person Cards");
        listStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
