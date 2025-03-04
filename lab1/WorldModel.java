import java.util.ArrayList;
import java.util.Random;

public class WorldModel {
    private ArrayList<Car> cars;
    private ArrayList<Mechanic> mechanics;
    WorldModel(){
        cars = new ArrayList<>();
        mechanics = new ArrayList<>();
    }
    public void addCar(Car car){
        cars.add(car);
    }
    public void addCar(){
        Car car;
        double randCar=Math.round(Math.random()*3);
        double randX=Math.round(Math.random()*800);
        double randY=Math.round(Math.random()*800);
        if (randCar == 1) {
            car = new Volvo240();
            car.setPosition(new double[] {randX,randY});
            cars.add(car);
        }
        if (randCar == 2) {
            car = new Saab95();
            car.setPosition(new double[] {randX,randY});
            cars.add(car);
        }
        if (randCar == 0 || randCar == 3) {
            car = new Scania();
            car.setPosition(new double[] {randX,randY});
            cars.add(car);
        }
    }
    public void removeCar(Car car){
        if (!cars.contains(car)) throw new IllegalArgumentException("Car is not in the world!");
        cars.remove(car);
    }
    public void removeCar(){
        int randCar = (int) Math.round(Math.random()* cars.size());
        cars.remove(randCar);
    }
    public void addMechanic(Mechanic mechanic){
        mechanics.add(mechanic);
    }
    public void removeMechanic(Mechanic mechanic){
        mechanics.remove(mechanic);
    }


}
