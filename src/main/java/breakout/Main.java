package breakout;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.Scanner;


public class Main extends Application {
    // useful names for constant values used
    public static final String TITLE = "Example JavaFX Animation";
    public static final int HEIGHT = 800;
    public static final int WIDTH = 1000;
    public static final int FPS = 60;
    public static final double SECOND_DELAY = 1.0 / FPS;

    private GameRunner myGame;


    /**
     * Initialize what will be displayed.
     */
    @Override
    public void start (Stage stage) {
        myGame = new GameRunner();

        Scene scene = myGame.setUpJet(1000, 800, Color.BLACK);
        stage.setScene(scene);
        stage.setTitle(TITLE);
        stage.show();

        Timeline animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(new KeyFrame(Duration.seconds(SECOND_DELAY), e -> myGame.stepJet(SECOND_DELAY)));
        animation.play();
    }

}
