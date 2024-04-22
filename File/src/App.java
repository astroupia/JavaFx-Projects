import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       Label lblName=new Label("Name");
        Label lblSex=new Label("Sex");
        Label lblAddress=new Label("Address");
        Label lblDob=new Label("DOB");
        TextField txtName=new TextField();
        RadioButton rbtnM=new RadioButton("Male");
        RadioButton rbtnF=new RadioButton("Female");
        ComboBox<String> cmbAddress=new ComboBox<>();
        cmbAddress.getItems().addAll("Arada","Bole","Yeka");
        DatePicker dp=new DatePicker();
        Button btnS=new Button("Save");
        Button btnC=new Button("Cancel");
        Button btnD=new Button("Display");
        btnC.setOnAction(e->{
        txtName.setText("");
        dp.setValue(null);
        cmbAddress.setValue(null);
        if(rbtnM.isSelected())
            rbtnM.selectedProperty().set(false);
        else if(rbtnF.isSelected())
          rbtnF.selectedProperty().set(false);  
        });
        btnS.setOnAction(e->{
                  
            FileWriter fw=null;
            try {
                File f=new File("C:\\Users\\Menbere\\Desktop\\april22.txt");
                fw = new FileWriter(f,true);
                String name=txtName.getText();
                String sex;
                if(rbtnM.isSelected())
                    sex="Male";
                else
                    sex="Female";
                String address=cmbAddress.getValue();
                String dob=dp.getValue().toString();
                fw.append("\n"+name+"\t"+sex+"\t"+address+"\t"+dob);
            } catch (IOException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        btnD.setOnAction(e->{
            BufferedReader bf=null;
            try {
                Stage stage=new Stage();
                Label lblOutput=new Label();
                File fout=new File("C:\\Users\\Menbere\\Desktop\\april22.txt");
                bf = new BufferedReader(new FileReader(fout));
                String out;
                String output="";
                while((out=bf.readLine())!=null)
                   output+=out+"\n";
                    lblOutput.setText(output);
                Pane pane=new Pane();
                pane.getChildren().add(lblOutput);
                Scene s= new Scene(pane,400,400);
                stage.setScene(s);
                stage.show();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    bf.close();
                } catch (IOException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        });
        ToggleGroup tgS=new ToggleGroup();
        rbtnM.setToggleGroup(tgS);
        rbtnF.setToggleGroup(tgS);
        HBox hb1=new HBox(20);
        HBox hb2=new HBox(20);
        HBox hb3=new HBox(20);
        HBox hb4=new HBox(20);
        HBox hb5=new HBox(20);
        VBox vb=new VBox(20);
        hb1.getChildren().addAll(lblName,txtName);
        hb2.getChildren().addAll(lblSex,rbtnM,rbtnF);
        hb3.getChildren().addAll(lblAddress,cmbAddress);
        hb4.getChildren().addAll(lblDob,dp);
        hb5.getChildren().addAll(btnS,btnC,btnD);
        vb.getChildren().addAll(hb1,hb2,hb3,hb4,hb5);
        vb.setPadding(new Insets(20,20,20,20));
        vb.setStyle("-fx-background-color:lightblue");
        Scene scene = new Scene(vb, 500, 300);
        primaryStage.setTitle("Form 1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
