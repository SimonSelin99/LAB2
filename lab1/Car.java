import java.awt.*;

public abstract class Car implements Movable{

    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private final Color color; // Color of the car
    private final String modelName; // The car model name
    private Direction currentDirection;
    private double[] position = new double[2];
    public enum Direction {UP, RIGHT, DOWN, LEFT}

    public Car(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        setCurrentDirection(Direction.UP);
        setPosition(new double[] {0,0});
        stopEngine();
    }

    public abstract double speedFactor();
    public int getNrDoors() { return nrDoors; }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    protected void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = Math.max(0,Math.min(currentSpeed, enginePower));
    }

    public Color getColor(){
        return color;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    private void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public String getModelName() { return modelName; }

    public double[] getPosition() { return position;}

    protected void setPosition(double[] position) {
        this.position = position;
    }

    public void incrementX(double x) { this.position[0] += x;}

    public void incrementY(double y) { this.position[1] += y;}

    public void gas(double amount) {
        double adjustedAmount = Math.max(0, Math.min(amount, 1)) * speedFactor();
        setCurrentSpeed(getCurrentSpeed() + adjustedAmount);
    }

    public void brake(double amount) {
        double adjustedAmount = Math.max(0, Math.min(amount, 1)) * speedFactor();
        setCurrentSpeed(getCurrentSpeed() - adjustedAmount);
    }
    @Override
    public void move() {
        switch(getCurrentDirection())
        {
            case Direction.UP:
                incrementY(getCurrentSpeed());
                break;
            case Direction.RIGHT:
                incrementX(getCurrentSpeed());
                break;
            case Direction.DOWN:
                incrementY(-getCurrentSpeed());
                break;
            case Direction.LEFT:
                incrementX(-getCurrentSpeed());
                break;
        }
    }

    @Override
    public void turnLeft() {
        switch(getCurrentDirection())
        {
            case Direction.UP:
                setCurrentDirection(Direction.LEFT);
                break;
            case Direction.RIGHT:
                setCurrentDirection(Direction.UP);
                break;
            case Direction.DOWN:
                setCurrentDirection(Direction.RIGHT);
                break;
            case Direction.LEFT:
                setCurrentDirection(Direction.DOWN);
                break;
        }
    }

    @Override
    public void turnRight() {
        switch(getCurrentDirection())
        {
            case Direction.UP:
                setCurrentDirection(Direction.RIGHT);
                break;
            case Direction.RIGHT:
                setCurrentDirection(Direction.DOWN);
                break;
            case Direction.DOWN:
                setCurrentDirection(Direction.LEFT);
                break;
            case Direction.LEFT:
                setCurrentDirection(Direction.UP);
                break;
        }
    }

}
