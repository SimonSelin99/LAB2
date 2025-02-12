import java.awt.*;

public class Transport extends Car {
    private final Storeable storeable;
    private final Truckbed truckbed;
    public Transport(int maxCars, String[] allowedCars){
        super(2,200,Color.black,"Transport");

        this.truckbed = new Truckbed(this);
        this.storeable = new Storeable(maxCars, allowedCars);
    }

    public double speedFactor(){
        return getEnginePower() * 0.01;
    }

    public void setTruckBed(boolean angle) {
        if (getCurrentSpeed() == 0) {
            if(angle){truckbed.setAngle(-100);}
            else {truckbed.setAngle(100);}
        }
    }

    public void loadCar(Car car) {
        /*
        if (car instanceof Truckbed) {
            throw new IllegalArgumentException("Truckbeds are not allowed");
        }

         */

        if (truckbed.getAngle() == 70) {
            storeable.loadCar(car, this.getPosition()); }
    }

    public void unLoadCar(int amount) {
        if (truckbed.getAngle() == 70) {
            storeable.unloadCar(amount, this.getPosition());
        }
    }
    @Override
    public void gas(double amount) {
        if (truckbed.getAngle() == 0) {
            gas(amount);
        }
    }
}