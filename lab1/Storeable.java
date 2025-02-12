
public class Storeable {

    private final Car[] storedCars;
    private int carIndex;
    private final int maxCars;

    Storeable(Car[] storedCars){
        this.storedCars = storedCars;
        this.maxCars = storedCars.length;
        this.carIndex = 0;
    }

    protected void loadCar(Car car, double[] position) {
        for (int i = 0; i < maxCars; i++) {
            if(null == storedCars[i]) {
                carIndex = i;
                break; }
        }

        if (carIndex == maxCars - 1) {
            throw new ArrayIndexOutOfBoundsException("Storage full"); }

        if (Math.abs(car.getPosition()[0] - position[0]) <= 1.0 &&
                Math.abs(car.getPosition()[1] - position[1]) <= 1.0) {
                    storedCars[carIndex] = car;
                    storedCars[carIndex].setPosition(position);
                    carIndex++;
                    return; }
        throw new IllegalArgumentException("Car too far away");
    }

    protected void unloadCar(int amount, double[] position) {
        while(amount>0){
            if (carIndex == 0) return;
            carIndex--;
            storedCars[carIndex].setPosition(new double[] {position[0], position[1]});
            storedCars[carIndex] = null;
            amount--;}
    }

    protected void unloadSpecificCar (Car car, double[] position){
        int ind = 0;
        for(Car c:storedCars) {
            if (car == c) {
                storedCars[ind].setPosition(new double[] {position[0], position[1]});
                storedCars[ind] = null;
                return;
            }
            ind++;
        }
        throw new IllegalArgumentException("Car not stored");
    }

    public Car[] getStoredCars() {
        return storedCars;
    }

    public int getMaxCars() {
        return maxCars;
    }

}