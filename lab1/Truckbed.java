import java.awt.*;

public class Truckbed {

    private int angle = 0;
    private final Car car;
    public Truckbed(Car car) {
        this.car = car;
    }

    protected void setAngle(int angle) {
        if (car.getCurrentSpeed() == 0) {
            this.angle = Math.max(Math.min(angle, 70), 0); }
    }

    public int getAngle(){return this.angle;}
}