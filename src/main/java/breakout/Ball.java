package breakout;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Ball extends Circle {
    private boolean myMain;
    private double myVelX;
    private double myVelY;

    private Paint initialColor = Color.WHITE;
    public final double INIT_VEL = 125;

    public Ball(double x, double y, double rad, double dx, double dy, boolean main){
        this.setCenterX(x);
        this.setCenterY(y);
        this.setRadius(rad);
        this.setVelX(dx);
        this.setVelY(dy);
        this.myMain = main;
        this.setFill(initialColor);
    }

    public void setVelX(double dx){
        this.myVelX = dx;
    }

    public void setVelY(double dy){
        this.myVelY = dy;
    }

    public void speedUp(double x, double y){
        this.myVelX += Math.signum(this.myVelX)*x;
        this.myVelY += Math.signum(this.myVelY)*y;;
    }

    public double getVelX(){
        return this.myVelX;
    }

    public double getVelY(){
        return this.myVelY;
    }

    public void randomizeColor(){
        Random rand = new Random();
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        this.setFill(Color.rgb(r, g, b));
    }

    public void reverse(){
        this.myVelX*=-1;
        this.myVelY*=-1;
    }

    public void reverseX(){
        this.myVelX*=-1;
    }

    public void reverseY(){
        this.myVelY*=-1;
    }

    public double getMag(){
        return Math.sqrt(Math.pow(this.myVelX, 2) + Math.pow(this.myVelY, 2));
    }
}
