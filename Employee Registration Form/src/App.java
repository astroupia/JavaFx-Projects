import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;


public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Setting Up  Menu
        MenuBar menu = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu findMenu = new Menu("Find Employee Data");
        Menu manageMenu = new Menu("Manage Employee Data");
        Menu helpMenu = new Menu("Help");

        menu.getMenus().addAll(fileMenu, findMenu, manageMenu, helpMenu);

        MenuItem openItem = new MenuItem("Open");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem employeeItem = new MenuItem("Employe");
        
        // Add MenuItems to the Menu
        fileMenu.getItems().addAll(openItem, saveItem, employeeItem);
        
        // Setting Up Lable 
        Text title = new Text("Employee Information Manager");
        Label yourName = new Label("Your Name");
        Label fatherName = new Label("Father Name");
        Label grandName = new Label("Grand-Father Name");
        Label sex = new Label("Sex: ");
        Label birthDate = new Label("Birth Date");
        Label address = new Label("Address");
        Label nationality = new Label("Nationality");
        Label occupation = new Label("Occupation");
        Label salary = new Label("Salary");
        Label education = new Label("Education");
        Label experience = new Label("Experience");
        Label phoneNumber = new Label("PhoneNumber");
        Label email = new Label("Email");
        Label employeeId = new Label("EmployeeId");
        TextArea showDataTextArea = new TextArea();
        showDataTextArea.setEditable(false); // Make showDataTextArea read-only
        showDataTextArea.setPrefHeight(200); // Set preferred height


        // Setting Up Fields
        TextField yourNameField = new TextField();
        TextField fatherNameField = new TextField();
        TextField grandNameField = new TextField();
        TextField addressField = new TextField();
        TextField nationalityField = new TextField();
        TextField salaryField = new TextField();
        TextField emailField = new TextField();
        TextField phoneField = new TextField();
        TextField empIdField = new TextField();

        ToggleGroup sexToggleGroup = new ToggleGroup();
        RadioButton radioButtonMale = new RadioButton("Male");
        RadioButton radioButtonFemale = new RadioButton("Female");
        DatePicker birthDatePicker = new DatePicker();

        ToggleGroup educationToggleGroup = new ToggleGroup();
        RadioButton radioButtonPhd = new RadioButton("PHD");
        RadioButton radioButtonElementary = new RadioButton("Elementary");
        RadioButton radioButtonHighSchool = new RadioButton("High-School");
        RadioButton radioButtonDiploma = new RadioButton("Diploma");
        RadioButton radioButtonBachlorDegree = new RadioButton("Bachlor-Degree");

        ToggleGroup experienceToggleGroup = new ToggleGroup();
        ToggleButton noExp = new ToggleButton("No Experience");
        ToggleButton oneExp = new ToggleButton("One Years Experience");
        ToggleButton twoExp = new ToggleButton("Two Years Experience");
        ToggleButton moreTwo = new ToggleButton("More Than Two"); 

        Button registerButton = new Button("Register");
        Button confirmDataButton = new Button("Confirm");

        // Toggle Check Box
        
        radioButtonMale.setToggleGroup(sexToggleGroup);
        radioButtonFemale.setToggleGroup(sexToggleGroup);

        radioButtonElementary.setToggleGroup(educationToggleGroup);
        radioButtonHighSchool.setToggleGroup(educationToggleGroup);
        radioButtonDiploma.setToggleGroup(educationToggleGroup);
        radioButtonBachlorDegree.setToggleGroup(educationToggleGroup);
        radioButtonPhd.setToggleGroup(educationToggleGroup);

        noExp.setToggleGroup(experienceToggleGroup);
        oneExp.setToggleGroup(experienceToggleGroup);
        twoExp.setToggleGroup(experienceToggleGroup);
        moreTwo.setToggleGroup(experienceToggleGroup);

        //Setting DropBox
        ComboBox<String> occupationComboBox = new ComboBox<>();
        
        // Add items to the occupationComboBox
        occupationComboBox.setItems(FXCollections.observableArrayList(
                "Security",
                "Accountant",
                "Software Engineer"
        ));
        
        // Set a default value for the occupationComboBox
        occupationComboBox.setValue("Select Occupation");

        // Setting Up Boxes
        HBox horizontalBoxMenu = new HBox();
        horizontalBoxMenu.getChildren().addAll(title, menu);

        HBox horizontalBoxOne = new HBox();
        horizontalBoxOne.setPadding(new Insets(10, 0, 10, 20));
        horizontalBoxOne.getChildren().addAll(yourName, yourNameField, fatherName, fatherNameField, grandName, grandNameField);
        horizontalBoxOne.setSpacing(10);

        HBox horizontalBoxTwo = new HBox();
        horizontalBoxTwo.setPadding(new Insets(10, 0, 10, 20));
        horizontalBoxTwo.getChildren().addAll(sex, radioButtonMale, radioButtonFemale, address, addressField, birthDate, birthDatePicker, nationality, nationalityField);
        horizontalBoxTwo.setSpacing(10);

        HBox horizontalBoxThree = new HBox();
        horizontalBoxThree.setPadding(new Insets(10, 0, 10, 20));
        horizontalBoxThree.getChildren().addAll(salary, salaryField, occupation, occupationComboBox, education, radioButtonElementary, radioButtonHighSchool, radioButtonDiploma, radioButtonBachlorDegree, radioButtonPhd);
        horizontalBoxThree.setSpacing(10);

        HBox horizontalBoxFour = new HBox();
        horizontalBoxFour.setPadding(new Insets(10, 0, 10, 20));
        horizontalBoxFour.getChildren().addAll(experience, noExp, oneExp, twoExp, moreTwo);
        horizontalBoxFour.setSpacing(10);

        HBox horizontalBoxFive = new HBox();
        horizontalBoxFive.setPadding(new Insets(10, 0, 10, 20));
        horizontalBoxFive.getChildren().addAll(phoneNumber, phoneField, email, emailField, employeeId, empIdField);
        horizontalBoxFive.setSpacing(10);

        HBox horizontalBoxSix = new HBox();
        horizontalBoxSix.setPadding(new Insets(10, 0, 10, 20));
        horizontalBoxSix.getChildren().addAll(registerButton, showDataTextArea);
        horizontalBoxSix.setSpacing(10);

        HBox horizontalBoxSeven = new HBox();
        horizontalBoxSix.setPadding(new Insets(10, 0, 10, 20));
        horizontalBoxSix.getChildren().addAll(confirmDataButton);
        horizontalBoxSix.setSpacing(10);


        VBox mainVBox = new VBox();
        mainVBox.setPadding(new Insets(0, 0, 10, 10));
        mainVBox.getChildren().addAll(menu, horizontalBoxOne, horizontalBoxTwo, horizontalBoxThree, horizontalBoxFour, horizontalBoxFive, horizontalBoxSix, horizontalBoxSeven);
        mainVBox.setSpacing(10);
        
        // Setting Up Pane
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(mainVBox);

        // Handling Button
        registerButton.setOnAction(e -> {
            File file = new File("dataReg.txt");
            try (BufferedWriter writeFile = new BufferedWriter(new FileWriter(file))) {
                writeFile.write(" First Name: " + yourNameField.getText() + "\n");
                writeFile.write(" Father Name: " + fatherNameField.getText()+ "\n");
                writeFile.write(" Grand Father Name: " + grandNameField.getText()+ "\n");
                writeFile.write(" Sex: " + sexToggleGroup.getSelectedToggle()+ "\n");
                writeFile.write(" Address: " + addressField.getText()+ "\n");
                writeFile.write(" Birth Date: " + birthDatePicker.getValue()+ "\n");
                writeFile.write(" Nationality: " + nationalityField.getText()+ "\n");
                writeFile.write(" Salary: " + salaryField.getText()+ "\n");
                writeFile.write(" Occupation: " + occupationComboBox.getValue()+ "\n");
                writeFile.write(" Eduaction Level" + educationToggleGroup.getSelectedToggle()+ "\n"); 
                writeFile.write(" Experience: " + experienceToggleGroup.getSelectedToggle()+ "\n");
                writeFile.write(" Phone Number: " + phoneField.getText()+ "\n");
                writeFile.write(" Email: " + emailField.getText()+ "\n");
                writeFile.write(" EmployeeId: " + phoneField.getText()+ "\n");
                writeFile.write("  ------ DONE ------ ");
                writeFile.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            
            // Reading From File
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                showDataTextArea.clear(); // Clear previous content
                String line;
                while ((line = reader.readLine()) != null) {
                    showDataTextArea.appendText(line + "\n"); // Append line and add a newline
             }
            } catch (IOException e2) {
                showDataTextArea.setText("Failed to load data: " + e2.getMessage());
            }
            });

        confirmDataButton.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Confirming Successful Registration");
            alert.setContentText("You have been registered successfully.");

            // Displaying the alert and waiting for the user to respond
            alert.showAndWait();
        });

        // Setting Up Scene
        Scene mainScene = new Scene(stackPane, 1000, 700);
        primaryStage.setScene(mainScene);

        // Setting Up Primary Stage
        primaryStage.setTitle("Employee Information Manager");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}