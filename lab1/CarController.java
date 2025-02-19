import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<Mechanic> mechanics = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        Volvo240 ccVolvo = new Volvo240();
        ccVolvo.setPosition(new double[] {0,300});
        Saab95 ccSaab = new Saab95();
        ccSaab.setPosition(new double[] {0,300});
        Scania ccScania = new Scania();
        ccScania.setPosition(new double[]{0,200});
        cc.cars.add(ccVolvo);
        cc.cars.add(ccSaab);
        cc.cars.add(ccScania);
        cc.mechanics.add(new Mechanic<>(new Volvo240[4]
                , new double[] {300,300}));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();

    }



    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int index = 0;
            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getPosition()[0]);
                int y = (int) Math.round(car.getPosition()[1]);
                if (frame.drawPanel.getWidth()-frame.drawPanel.volvoImage.getWidth() < x
                        || 0 > x){
                    car.turnRight();
                    car.turnRight();
                }
                if (frame.drawPanel.getHeight() - frame.drawPanel.volvoImage.getHeight() < y
                        || 0 > y){
                    car.turnRight();
                    car.turnRight();
                }
                matchMechanic(car);

                frame.drawPanel.moveit(x, y, index++);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();

            }
        }
    }
    void matchMechanic(Car car){
        for (Mechanic mechanic:mechanics){
            if (Math.abs(mechanic.getPosition()[0] - car.getPosition()[0]) <= 25 &&
                    Math.abs(mechanic.getPosition()[1] - car.getPosition()[1]) <= 25){
                if(mechanic.getStoredCars().getClass().getComponentType()
                        .equals(car.getClass())){
                mechanic.loadCar(car);
                }
            }
        }
    }
    boolean storedInMechanic(Car car){
        for (Mechanic mechanic : mechanics){
            for (Car storedCar : mechanic.getStoredCars()){
                if(storedCar == car) return true;
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
    void stopEngine(){
        for (Car car : cars
        ) {
            car.stopEngine();
        }
    }
    void startEngine(){
        for (Car car : cars
        ) {
            if (storedInMechanic(car)) continue;
            car.startEngine();
        }
    }
    void turboOff(){
        for (Car car : cars) {
            if (car.getClass().equals(Saab95.class))
                ((Saab95) car).setTurboOff();
        }
    }
    void turboOn(){
        for (Car car : cars) {
            if (car.getClass().equals(Saab95.class))
                ((Saab95) car).setTurboOn();
        }
    }
    void liftBed(){
        for (Car car : cars) {
            if (car.getClass().equals(Scania.class))
                ((Scania) car).decrementTruckBed(10);
        }
    }
    void lowerBed(){
        for (Car car : cars) {
            if (car.getClass().equals(Scania.class))
                ((Scania) car).incrementTruckBed(10);
        }
    }

}

