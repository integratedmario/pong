package breakout;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import java.util.Scanner;

public class GameRunner {
    public static final String TITLE = "Example JavaFX Animation";
    public static final int SIZE = 1000;
    public final double INIT_VEL = 300;


    private Paddle myPaddle;
    private Paddle theirPaddle;
    private Ball myBall;
    private Group myRoot;
    private Scene myScene;
    private Text redScore;
    private Text blueScore;
    private int colCount = 0;
    private int roundColCount = 0;

    public Scene setUpJet (double height, double width, Paint background) {
        Scanner scanner = new Scanner(System.in);
        //int diff = scanner.nextInt();
        myPaddle = new Paddle(500, 780, 10, 155, 3);
        myPaddle.setFill(Color.RED);
        theirPaddle = new Paddle(500, 20, 10, 155, 3);
        theirPaddle.setFill(Color.BLUE);

        redScore = new Text(910, 760, "Player RED:" + myPaddle.getScore());
        redScore.setStroke(Color.WHITE);
        blueScore = new Text(10, 40, "Player BLUE:" + theirPaddle.getScore());
        blueScore.setStroke(Color.WHITE);


        myBall = new Ball(400, 400, 15, INIT_VEL, INIT_VEL, true);

        myRoot = new Group();
        myRoot.getChildren().add(myPaddle);
        myRoot.getChildren().add(myBall);
        myRoot.getChildren().add(theirPaddle);
        myRoot.getChildren().add(redScore);
        myRoot.getChildren().add(blueScore);

        Scene scene = new Scene(myRoot, height, width, background);
        scene.setOnMouseMoved(e -> handleMouseDrag(e.getX()));
        scene.setOnMouseClicked(e -> handleMouseClick(e.getButton()));
        scene.setOnKeyPressed(e -> handleKeyPress(e.getCode()));
        myScene = scene;
        return scene;
    };

    /*
    Following function handles all keyboard input and game occurences
    at the appropriate FPS specified in Main.
     */
    public void stepJet(double time){
        double ballCent = myBall.getCenterX() + (myBall.getRadius()/2);
        double paddleCent = myPaddle.getX() + (myPaddle.getWidth()/2);
        double theirCent = theirPaddle.getX() + (theirPaddle.getWidth()/2);
        myBall.setCenterX(myBall.getCenterX() + myBall.getVelX() * time);
        myBall.setCenterY(myBall.getCenterY() + myBall.getVelY() * time);
        if(intBallPaddle(myPaddle, myBall) || intBallPaddle(theirPaddle, myBall)) {
            repelHandler();
        }
        if(myBall.getCenterX() < 0 || myBall.getCenterX() > 1000) myBall.setVelX(-myBall.getVelX());
        if(myBall.getCenterY() < 0) {
            outHandler(myPaddle);
            redScore.setText("Player RED: " + myPaddle.getScore());
        }
        if(myBall.getCenterY() > 800) {
            outHandler(theirPaddle);
            blueScore.setText("Player BLUE: " + theirPaddle.getScore());
        }
    }

    private void handleMouseDrag(double x) {
        myPaddle.setX(Math.min(x, SIZE-myPaddle.getWidth()));
    }

    private void handleMouseClick(MouseButton button){
        if (button == MouseButton.PRIMARY) {
            myBall.setVelX(1.5*myBall.getVelX());
            myBall.setVelY(1.5*myBall.getVelY());
        }
        if (button == MouseButton.SECONDARY) {
            myBall.setVelX(0.66*myBall.getVelX());
            myBall.setVelY(0.66*myBall.getVelY());
        }
        if (button == MouseButton.MIDDLE) {
            myBall.setCenterX(500);
            myBall.setCenterY(500);
        }
    }
    /*
    Handles collisions between the ball and the paddles,
    and may ramp up difficulty depending on game time.
     */
    private void repelHandler(){
        myBall.reverseY();
        colCount += 1;
        roundColCount += 1;
        if (roundColCount % 7 == 0) {
            myBall.speedUp(60, 60);
            myBall.randomizeColor();
        }
    }
    /*
    Restarts the "round" when a paddle fails to repel the ball
    and adjusts score accordingly.
     */
    private void outHandler(Paddle curr){
        curr.updtScore(1);
        myRoot.getChildren().remove(myBall);
        myBall = new Ball(400, 400, 15, INIT_VEL, INIT_VEL, true);
        myRoot.getChildren().add(myBall);
        roundColCount = 0;
    }

    private void handleKeyPress(KeyCode code){
        if (code == KeyCode.F) {
            myPaddle.setFill(Color.WHITE);
            setTimeout(() -> myPaddle.setFill(Color.RED), 0);
            setTimeout(() -> myPaddle.setFill(Color.YELLOW), 200);
            setTimeout(() -> myPaddle.setFill(Color.BLUEVIOLET), 400);
            setTimeout(() -> myPaddle.setFill(Color.LIGHTSTEELBLUE), 600);
            setTimeout(() -> myPaddle.setFill(Color.RED), 600);
        }
        if(code == KeyCode.A){
            theirPaddle.setX(Math.max(0, theirPaddle.getX() - 25));
        }
        if(code == KeyCode.D){
            theirPaddle.setX(Math.min(SIZE - theirPaddle.getWidth(), theirPaddle.getX() + 25));
        }
    }

    // Execution delay function borrowed from Stack Overflow.
    public static void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }

    public boolean intBallPaddle(Paddle a, Ball b){
        return a.getBoundsInLocal().intersects(b.getBoundsInLocal());
    }
}
