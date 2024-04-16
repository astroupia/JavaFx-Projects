import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Flag extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane(); // Create a pane
        ImageView imageView = new ImageView("./assets/Flag.jpg"); // Load an image (flag)
        pane.getChildren().add(imageView); // Add the image to the pane

        PathTransition pt = new PathTransition(); // Create a PathTransition
        pt.setDuration(Duration.millis(3000)); // Set the duration of the animation to 3 seconds

        // Define the path for the animation using a Line from (100, 200) to (100, 0)
        pt.setPath(new Line(100, 200, 100, 0));
        pt.setNode(imageView); // Set the node to animate (the flag)
        pt.setCycleCount(PathTransition.INDEFINITE); // Set the cycle count to indefinite (animation repeats indefinitely)
        pt.play(); // Start the animation

        Scene scene = new Scene(pane, 250, 200); // Create a scene with the pane
        primaryStage.setScene(scene); // Set the scene on the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        launch(args); // Launch the application
    }
}
