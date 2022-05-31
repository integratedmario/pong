package breakout;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import java.util.*;

public class Paddle extends Rectangle {
    private int myScore;
    private ArrayList<String> myItems;

    public Paddle(double x, double y, double height, double width, int lives){
        this.setX(x);
        this.setY(y);
        this.setHeight(height);
        this.setWidth(width);
        this.setScore(0);
    }

    public int getScore(){
        return this.myScore;
    }

    public void setScore(int x){
        this.myScore = x;
    }

    public void updtScore(int x){
        this.myScore += x;
    }
}
