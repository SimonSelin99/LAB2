import javax.swing.*;

public class Main {
    private static final int X = 800;
    private static final int Y = 800;
    public static void main(String[] args) {

       DrawPanel drawPanel =new DrawPanel(X, Y-240);
       View carView = new CarView("CarSim 1.3.3.7", drawPanel, X, Y);
        Observable observable = new Observable();
        observable.addObserver(carView);
        WorldModel model = new WorldModel(observable);
        CarController cc = new CarController(model, carView, X, Y);

        Volvo240 ccVolvo = new Volvo240();
        ccVolvo.setPosition(new double[]{0, 300});
        Saab95 ccSaab = new Saab95();
        ccSaab.setPosition(new double[]{0, 300});
        Scania ccScania = new Scania();
        ccScania.setPosition(new double[]{0, 200});
        cc.addCar(ccVolvo);
        cc.addCar(ccSaab);
        cc.addCar(ccScania);
        cc.addMechanic(new Mechanic<>(new Volvo240[4]
                , new double[]{300, 300}));
        //cc.start();
    }

}
