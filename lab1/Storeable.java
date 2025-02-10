
public class Storeable {

    private final int maxCars;
    private final Car[] storedCars;
    private final String[] allowedCars;
    private int carIndex;

    Storeable(int maxCars, String[] allowedCars){
        this.maxCars = maxCars;
        this.allowedCars = allowedCars;
        this.storedCars = new Car[maxCars];
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
            for(String s: allowedCars) {
                if (car.getModelName().equals(s)) {
                    storedCars[carIndex] = car;
                    storedCars[carIndex].setPosition(position);
                    carIndex++;
                    return; }
            }
            throw new IllegalArgumentException("Car not allowed");
        }
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

    public String[] getAllowedCars() {
        return allowedCars;
    }
}