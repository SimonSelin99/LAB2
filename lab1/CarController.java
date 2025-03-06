import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class CarController {
    private final int delay = 50;
    private Timer timer;
    private WorldModel model;
    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<Mechanic> mechanics = new ArrayList<>();
    public CarController(WorldModel model) {
        this.model = model;
        this.timer = new Timer(delay, new TimerListener(this));
    }
    public void start() {
        timer.start();
    }

    public void updateCars() {
        model.updateWorldState();
    }
    void gas(int amount) { model.gas(amount); }
    void brake(int amount) { model.brake(amount); }
    void stopEngine() { model.stopEngine(); }
    void startEngine() { model.startEngine(); }
    void turboOff() { model.turboOff(); }
    void turboOn() { model.turboOn(); }
    void liftBed() { model.liftBed(); }
    void lowerBed() { model.lowerBed(); }
    void addCar(Car car) {model.addCar(car);}
    void addCar() {model.addCar();}
    void addMechanic(Mechanic mechanic) {model.addMechanic(mechanic);}
    void removeCar(Car car) {model.removeCar(car);}
    void removeCar(){model.removeCar();}


    }

