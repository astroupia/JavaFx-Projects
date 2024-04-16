import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MovingDvd extends Application {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;
    private static final int IMAGE_SIZE = 100;

    private ImageView imageView;
    private int directionX = 1;
    private int directionY = 1;

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("DVD");

        // Load the image
        Image image = new Image("./dvd.png");
        
        // Create the image view
        imageView = new ImageView(image);
        imageView.setFitWidth(IMAGE_SIZE);
        imageView.setFitHeight(IMAGE_SIZE);
        root.getChildren().add(imageView);

        // Set initial position of the image
        imageView.setX(WIDTH / 2 - IMAGE_SIZE / 2);
        imageView.setY(HEIGHT / 2 - IMAGE_SIZE / 2);

        // Set up animation timer to move the image
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                moveImage();
            }
        };
        timer.start();

        primaryStage.show();
    }

    private void moveImage() {
        // Calculate new position
        double newX = imageView.getX() + directionX;
        double newY = imageView.getY() + directionY;

        // Check boundary collision
        if (newX <= 0 || newX >= WIDTH - IMAGE_SIZE) {
            directionX *= -1; // Reverse X direction
        }
        if (newY <= 0 || newY >= HEIGHT - IMAGE_SIZE) {
            directionY *= -1; // Reverse Y direction
        }

        // Update image position
        imageView.setX(newX);       
        imageView.setY(newY);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
