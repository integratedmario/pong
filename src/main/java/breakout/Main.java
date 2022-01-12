package breakout;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;


/**
 * Feel free to completely change this code or delete it entirely.
 *
 * @author YOUR NAME HERE
 */
public class Main extends Application {
    // useful names for constant values used
    public static final String TITLE = "Example JavaFX Animation";
    public static final int SIZE = 1000;


    /**
     * Initialize what will be displayed.
     */
    @Override
    public void start (Stage stage) {
        Rectangle testPaddle = new Rectangle(460, 504, 80, 8);
        testPaddle.setFill(Color.LIGHTSTEELBLUE);

        Group root = new Group();
        root.getChildren().add(testPaddle);

        Scene scene = new Scene(root, SIZE, SIZE, Color.BLACK);
        stage.setScene(scene);

        stage.setTitle(TITLE);
        stage.show();
    }
}
