import java.awt.*;

public class Scania extends Truckbed{
    public Scania(){
        super(2,200,Color.black,"Scania");

        setTruckBed(0);
        stopEngine();
    }

    public <I> void setTruckBed(I angle) {
        if (getCurrentSpeed() == 0) {
            this.setAngle((int) angle);
        }
    }

    public double speedFactor(){
        return getEnginePower() * 0.01;
    }

    public void incrementTruckBed(int angle){
        setTruckBed(angle);

    }
    public void decrementTruckBed(int angle){setTruckBed(-angle);}
}