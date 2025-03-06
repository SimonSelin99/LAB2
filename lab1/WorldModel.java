import java.util.ArrayList;
import java.util.Random;

public class WorldModel {
    private ArrayList<Car> cars;
    private ArrayList<Mechanic> mechanics;
    private View carView;
    private CarController carController;

    public WorldModel() {
        cars = new ArrayList<>();
        mechanics = new ArrayList<>();
        carController = new CarController(this);
        this.carView = new CarView("CarSim 1.0",carController);
        carController.start();
    }


    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCar() {
        if(10 == cars.size()) return;
        Car car;
        double randCar = Math.round(Math.random() * 3);
        double randX = Math.round(Math.random() * 600);
        double randY = Math.round(Math.random() * 500);
        if (1 == randCar) {
            car = new Volvo240();
            car.setPosition(new double[]{randX, randY});
            cars.add(car);
        }
        if (2 == randCar) {
            car = new Saab95();
            car.setPosition(new double[]{randX, randY});
            cars.add(car);
        }
        if (0 == randCar || 3 == randCar) {
            car = new Scania();
            car.setPosition(new double[]{randX, randY});
            cars.add(car);
        }
    }

    public void removeCar(Car car) {
        if (!cars.contains(car)) throw new IllegalArgumentException("Car is not in the world!");
        cars.remove(car);
    }

    public void removeCar() {
        if (cars.isEmpty()) return;
        int randCar = (int) Math.round(Math.random() * (cars.size()-1));
        cars.remove(randCar);
    }

    public void addMechanic(Mechanic mechanic) {
        mechanics.add(mechanic);
    }

    public void removeMechanic(Mechanic mechanic) {
        mechanics.remove(mechanic);
    }

        public void updateWorldState() {
            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getPosition()[0]);
                int y = (int) Math.round(car.getPosition()[1]);

                if (carView.getX1()-carView.getPicWidth() < x
                        || 0 > x){
                    car.turnRight();
                    car.turnRight();
                }
                if (carView.getY1() - carView.getPicHeight() < y
                        || 0 > y){
                    car.turnRight();
                    car.turnRight();
                }


                matchMechanic(car);

                //view.drawPanel.moveit(x, y, index++);
                // repaint() calls the paintComponent method of the panel

            }
            carView.moveIt(cars);
            carView.drawComponents();
        }


    void matchMechanic(Car car) {
        for (Mechanic mechanic : mechanics) {
            if (Math.abs(mechanic.getPosition()[0] - car.getPosition()[0]) <= 25 &&
                    Math.abs(mechanic.getPosition()[1] - car.getPosition()[1]) <= 25) {
                if (mechanic.getStoredCars().getClass().getComponentType()
                        .equals(car.getClass())) {
                    mechanic.loadCar(car);
                }
            }
        }
    }

    boolean storedInMechanic(Car car) {
        for (Mechanic mechanic : mechanics) {
            for (Car storedCar : mechanic.getStoredCars()) {
                if (storedCar == car) return true;
            }
        }
        return false;
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            if (storedInMechanic(car)) continue;
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(brake);
        }
    }

    void stopEngine() {
        for (Car car : cars
        ) {
            car.stopEngine();
        }
    }

    void startEngine() {
        for (Car car : cars
        ) {
            if (storedInMechanic(car)) continue;
            car.startEngine();
        }
    }

    void turboOff() {
        for (Car car : cars) {
            if (car.getClass().equals(Saab95.class))
                ((Saab95) car).setTurboOff();
        }
    }

    void turboOn() {
        for (Car car : cars) {
            if (car.getClass().equals(Saab95.class))
                ((Saab95) car).setTurboOn();
        }
    }

    void liftBed() {
        for (Car car : cars) {
            if (car.getClass().equals(Scania.class))
                ((Scania) car).decrementTruckBed(10);
        }
    }

    void lowerBed() {
        for (Car car : cars) {
            if (car.getClass().equals(Scania.class))
                ((Scania) car).incrementTruckBed(10);
        }
    }
}
