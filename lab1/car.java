import java.awt.*;

public abstract class car implements Movable{

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Direction currentDirection;
    private double[] position = new double[2];
    public enum Direction {UP, RIGHT, DOWN, LEFT};

    public int getNrDoors() { return nrDoors; }

    protected void setNrDoors(int nrDoors) {
        this.nrDoors = nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    protected void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
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

    protected void setColor(Color color){
        this.color = color;
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

    protected void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public String getModelName() { return modelName; }

    protected void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public double[] getPosition() { return position;}

    protected void setPosition(double[] position) {
        this.position = position;
    }

    public void incrementX(double x) { this.position[0] += x;}

    public void incrementY(double y) { this.position[1] += y;}

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
