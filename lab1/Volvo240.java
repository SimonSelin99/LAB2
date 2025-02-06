import java.awt.*;

public class Volvo240 extends car{

    public final static double trimFactor = 1.25;

    
    public Volvo240(){
        setNrDoors(4);
        setColor(Color.black);
        setEnginePower(100);
        setModelName("Volvo240");
        setCurrentDirection(Direction.UP);
        setPosition(new double[] {0,0});
        stopEngine();
    }

    
    private double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
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
