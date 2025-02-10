import java.awt.*;

public class Transport extends Truckbed {
    public final Storeable storeable;
    public Transport(int maxCars, String[] allowedCars){
        super(2,200,Color.black,"Transport");

        setTruckBed(true);
        this.storeable = new Storeable(maxCars, allowedCars);
    }

    public double speedFactor(){
        return getEnginePower() * 0.01;
    }

    public <I> void setTruckBed(I angle) {
        if (getCurrentSpeed() == 0) {
            if((boolean) angle){setAngle(-100);}
            else {setAngle(100);}
        }
    }

    public void loadCar(Car car) {
        if (car instanceof Truckbed) {
            throw new IllegalArgumentException("Truckbeds are not allowed");
        }

        if (this.getAngle() == 70) {
            storeable.loadCar(car, this.getPosition()); }
    }

    public void unLoadCar(int amount) {
        if (this.getAngle() == 70) {
            storeable.unloadCar(amount, this.getPosition());
        }
    }
}