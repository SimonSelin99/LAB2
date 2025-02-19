
public class Mechanic <T extends Car>{
    private Storeable storeable;
    private final double[] position;
    public Mechanic(T[] storedCars, double[] position){
        this.storeable = new Storeable(storedCars);
        this.position = position;
    }
    public void getCar(Car car){
        storeable.unloadSpecificCar(car,position);
    }
    public void loadCar(Car car){
        storeable.loadCar(car, car.getPosition());
    }
    public Car[] getStoredCars() {return storeable.getStoredCars();}
    public double[] getPosition() {return this.position;}
}
