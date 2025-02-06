import java.awt.*;

public class Saab95 extends car{

    public boolean turboOn;
    public Saab95(){
        setNrDoors(2);
        setColor(Color.red);
        setEnginePower(125);
	    turboOn = false;
        setModelName("Saab95");
        setCurrentDirection(Direction.UP);
        setPosition(new double[] {0,0});
        stopEngine();
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return super.getEnginePower() * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    public void decrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

    public void gas(double amount){
        incrementSpeed(Math.max(0,Math.min(amount,1)));
    }

    public void brake(double amount){
        decrementSpeed(Math.max(0,Math.min(amount,1)));
    }
}
