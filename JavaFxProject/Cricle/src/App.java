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
        DatePicker datePicker = new DatePicker();

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
        ComboBox<String> comboBox = new ComboBox<>();
        
        // Add items to the ComboBox
        comboBox.setItems(FXCollections.observableArrayList(
                "Security",
                "Accountant",
                "Software Engineer"
        ));
        
        // Set a default value for the ComboBox
        comboBox.setValue("Select Occupation");

        // Setting Up Boxes
        HBox horizontalBoxMenu = new HBox();
        horizontalBoxMenu.getChildren().addAll(title, menu);

        HBox horizontalBoxOne = new HBox();
        horizontalBoxOne.setPadding(new Insets(10, 0, 10, 20));
        horizontalBoxOne.getChildren().addAll(yourName, yourNameField, fatherName, fatherNameField, grandName, grandNameField);
        horizontalBoxOne.setSpacing(10);

        HBox horizontalBoxTwo = new HBox();
        horizontalBoxTwo.setPadding(new Insets(10, 0, 10, 20));
        horizontalBoxTwo.getChildren().addAll(sex, radioButtonMale, radioButtonFemale, address, addressField, birthDate, datePicker, nationality, nationalityField);
        horizontalBoxTwo.setSpacing(10);

        HBox horizontalBoxThree = new HBox();
        horizontalBoxThree.setPadding(new Insets(10, 0, 10, 20));
        horizontalBoxThree.getChildren().addAll(salary, salaryField, occupation, comboBox, education, radioButtonElementary, radioButtonHighSchool, radioButtonDiploma, radioButtonBachlorDegree, radioButtonPhd);
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
        horizontalBoxSix.getChildren().addAll(registerButton);
        horizontalBoxSix.setSpacing(10);

        VBox mainVBox = new VBox();
        mainVBox.setPadding(new Insets(0, 0, 10, 10));
        mainVBox.getChildren().addAll(menu, horizontalBoxOne, horizontalBoxTwo, horizontalBoxThree, horizontalBoxFour, horizontalBoxFive, horizontalBoxSix);
        mainVBox.setSpacing(10);
        
        // Setting Up Pane
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(mainVBox);

        // Handling Button
        registerButton.setOnAction(e -> {
            File file = new File("./file.txt");
            try (FileWriter writeFile = new FileWriter(file)) {
                writeFile.write(yourNameField.getText());
                writeFile.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
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