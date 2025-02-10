import java.awt.*;

abstract public class Truckbed extends Car {
    private int angle = 0;
    public Truckbed(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }

    public abstract <I> void setTruckBed(I angle);

    protected void setAngle(int angle) {
        if (getCurrentSpeed() == 0) {
            this.angle = Math.max(Math.min(angle, 70), 0); }
    }

    @Override
    public void gas(double amount){
        if(getAngle()==0){
            double adjustedAmount = Math.max(0, Math.min(amount, 1)) * speedFactor();
            setCurrentSpeed(getCurrentSpeed() + adjustedAmount); }
    }

    public int getAngle(){return this.angle;}
}