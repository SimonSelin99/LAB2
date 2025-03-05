import java.util.ArrayList;
import java.util.Random;

public class WorldModel {
    private ArrayList<Car> cars;
    private ArrayList<Mechanic> mechanics;
    private CarView view;

    public WorldModel(CarController cc) {
        this.view = new CarView("CarSim 1.0",cc);
        cars = new ArrayList<>();
        mechanics = new ArrayList<>();
    }

    WorldModel() {
        cars = new ArrayList<>();
        mechanics = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCar() {
        Car car;
        double randCar = Math.round(Math.random() * 3);
        double randX = Math.round(Math.random() * 800);
        double randY = Math.round(Math.random() * 800);
        if (randCar == 1) {
            car = new Volvo240();
            car.setPosition(new double[]{randX, randY});
            cars.add(car);
        }
        if (randCar == 2) {
            car = new Saab95();
            car.setPosition(new double[]{randX, randY});
            cars.add(car);
        }
        if (randCar == 0 || randCar == 3) {
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
        int randCar = (int) Math.round(Math.random() * cars.size());
        cars.remove(randCar);
    }

    public void addMechanic(Mechanic mechanic) {
        mechanics.add(mechanic);
    }

    public void removeMechanic(Mechanic mechanic) {
        mechanics.remove(mechanic);
    }

        public void updateWorldState() {
            int index = 0;
            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getPosition()[0]);
                int y = (int) Math.round(car.getPosition()[1]);
                if (view.drawPanel.getWidth()-view.drawPanel.volvoImage.getWidth() < x
                        || 0 > x){
                    car.turnRight();
                    car.turnRight();
                }
                if (view.drawPanel.getHeight() - view.drawPanel.volvoImage.getHeight() < y
                        || 0 > y){
                    car.turnRight();
                    car.turnRight();
                }
                matchMechanic(car);

                view.drawPanel.moveit(x, y, index++);
                // repaint() calls the paintComponent method of the panel
                view.drawPanel.repaint();

            }
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
