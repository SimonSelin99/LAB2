import java.awt.*;

public class Mechanic {
    public final Storeable storeable;
    private final double[] position;
    public Mechanic(int maxCars, String[] allowedCars, double[] position){
        this.storeable = new Storeable(maxCars, allowedCars);
        this.position=position;
    }
    public void getCar(car car){
        storeable.unloadSpecificCar(car,position);
    }
    public void loadCar(car car){
        storeable.loadCar(car, car.getPosition());
    }
}
