import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class BounceBall extends Application {

    @Override
    public void start(Stage primaryStage) {
        BallPane ballPane = new BallPane(); // Create a ball pane
        
        // Pause and resume animation
        ballPane.setOnMousePressed(e -> ballPane.pause());
        ballPane.setOnMouseReleased(e -> ballPane.play());
        
        // Increase and decrease animation speed
        ballPane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP)
                ballPane.increaseSpeed();
            else if (e.getCode() == KeyCode.DOWN)
                ballPane.decreaseSpeed();
        });

        Scene scene = new Scene(ballPane, 450, 350);
        primaryStage.setTitle("Bounce Ball Control");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Must request focus after the primary stage is displayed
        ballPane.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}