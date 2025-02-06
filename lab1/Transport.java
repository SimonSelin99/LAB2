import java.awt.*;

public class Transport extends Truckbed {
    public final Storeable storeable;
    public Transport(int maxCars, String[] allowedCars){
        setNrDoors(2);
        setColor(Color.black);
        setEnginePower(200);
        setModelName("Transport");
        setCurrentDirection(Direction.UP);
        setPosition(new double[] {0,0});
        stopEngine();
        setRamp(true);
        this.storeable = new Storeable(maxCars, allowedCars);
    }

    private double speedFactor(){
        return getEnginePower() * 0.01;
    }

    public void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    public void decrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

    public void gas(double amount){
        if(getTruckbed()==0){
            incrementSpeed(Math.max(0,Math.min(amount,1)));
        }
    }

    public void brake(double amount){
        decrementSpeed(Math.max(0,Math.min(amount,1)));
    }

    public void setRamp(boolean rampUp) {
        setTruckBed(rampUp);
    }
    public void loadCar(car car) {
        if (car instanceof Truckbed) {
            throw new IllegalArgumentException("Truckbeds are not allowed");
        }

        if (this.getTruckbed() == 70) {
            storeable.loadCar(car, this.getPosition());
        }
    }
    public void unLoadCar(int amount) {
        if (this.getTruckbed() == 70) {
            storeable.unloadCar(amount, this.getPosition());
        }
    }
}
