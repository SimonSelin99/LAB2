public class Main {

    public static void main(String[] args) {
        CarController cc = new CarController();
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
        //world.view = new CarView("CarSim 1.0");
        cc.start();
    }

}
