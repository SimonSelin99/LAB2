import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class CarController{

    private WorldModel model;

    private int X;
    private int Y;

    public CarController(WorldModel model, int X, int Y) {
        this.X = X;
        this.Y = Y;
        this.model = model;
    }

    public void updateCars() {
        model.updateWorldState();
    }
    void gas(int amount) {
        model.gas(amount);
    }
    void brake(int amount) {
        model.brake(amount);
    }
    void stopEngine() {
        model.stopEngine();
    }
    void startEngine() {
        model.startEngine();
    }
    void turboOff() {
        model.turboOff();
    }
    void turboOn() {
        model.turboOn();
    }
    void liftBed() {
        model.liftBed();
    }
    void lowerBed() {
        model.lowerBed();
    }
    void addCar(Car car) {
        model.addCar(car);
    }
    void addCar() {
        model.addCar();
    }
    void addMechanic(Mechanic mechanic) {
        model.addMechanic(mechanic);
    }
    void removeCar(Car car) {
        model.removeCar(car);
    }
    void removeCar() {
        model.removeCar();
    }

    void setWorldSize(int[] worldSize) {model.setWorldSize(worldSize);}
    void setPicSize(int[] picSize) {model.setPicSize(picSize);}



}

