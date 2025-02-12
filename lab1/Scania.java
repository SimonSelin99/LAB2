import java.awt.*;

public class Scania extends Car{

    private final Truckbed truckbed;

    public Scania(){
        super(2,200,Color.black,"Scania");
        this.truckbed = new Truckbed(this);
        stopEngine();
    }

    public  void setTruckBed(int angle) {
        if (getCurrentSpeed() == 0) {
            truckbed.setAngle(angle);
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