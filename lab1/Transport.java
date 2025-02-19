import java.awt.*;

public class Transport<T extends SmallCar> extends BigCar{
    private final Storeable storeable;
    private final Truckbed truckbed;
    public Transport(T[] storedCars){
        super(2,200,Color.black,"Transport");
        this.truckbed = new Truckbed(this);
        this.storeable = new Storeable(storedCars);
    }

    public double speedFactor(){
        return getEnginePower() * 0.01;
    }

    public void setTruckBed(boolean rampUp) {
        if (getCurrentSpeed() == 0) {
            if(rampUp){truckbed.setAngle(-100);}
            else {truckbed.setAngle(100);}
        }
    }

    public void loadCar(SmallCar car) {
        if (truckbed.getAngle() == 70) {
            storeable.loadCar(car, this.getPosition()); }
    }

    public void unLoadCar(int amount) {
        if (truckbed.getAngle() == 70) {
            storeable.unloadCar(amount, this.getPosition());
        }
    }
    public Car[] getStoredCars() {return storeable.getStoredCars();}

    public boolean getRampUp(){
        return truckbed.getAngle() == 0;
    }

    @Override
    public void gas(double amount) {
        if (truckbed.getAngle() == 0) {
            super.gas(amount);
        }
    }
}