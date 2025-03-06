public class Main {
    public static void main(String[] args) {
       // DrawPanel drawPanel =new DrawPanel(X, Y-240);
       // View carView = new CarView("CarSim 1.0",cc, drawPanel);
        WorldModel model =new WorldModel();
        //CarController cc = new CarController(model);
        //CarView carView = new CarView("CarSim 1.0",cc);

        Volvo240 ccVolvo = new Volvo240();
        ccVolvo.setPosition(new double[]{0, 300});
        Saab95 ccSaab = new Saab95();
        ccSaab.setPosition(new double[]{0, 300});
        Scania ccScania = new Scania();
        ccScania.setPosition(new double[]{0, 200});
        model.addCar(ccVolvo);
        model.addCar(ccSaab);
        model.addCar(ccScania);
        model.addMechanic(new Mechanic<>(new Volvo240[4]
                , new double[]{300, 300}));
        //cc.start();
    }

}
