import java.awt.*;

public class Scania extends Truckbed{
    public Scania(){
        setNrDoors(2);
        setColor(Color.black);
        setEnginePower(200);
        setModelName("Scania");
        setCurrentDirection(Direction.UP);
        setPosition(new double[] {0,0});
        setTruckBed(0);
        stopEngine();
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
        }}

    public void brake(double amount){
        decrementSpeed(Math.max(0,Math.min(amount,1)));
    }

    public void incrementTruckbed(int angle){
        setTruckBed(angle);

    }
    public void decrementTruckbed(int angle){setTruckBed(-angle);}

}
