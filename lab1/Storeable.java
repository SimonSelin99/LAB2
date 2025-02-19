
public class Storeable<T extends Car> {

    private final T[] storedCars;
    private int carIndex;
    private final int maxCars;

    Storeable(T[] storedCars){
        this.storedCars = storedCars;
        this.maxCars = storedCars.length;
        this.carIndex = 0;
    }

    protected void loadCar(T car, double[] position) {
        for(T storedCar:storedCars){
            if(storedCar == car){
                return;
            }
        }
        for (int i = 0; i < maxCars; i++) {
            if(null == storedCars[i]) {
                carIndex = i;
                break; }
        }

        if (carIndex == maxCars - 1) {
            throw new ArrayIndexOutOfBoundsException("Storage full"); }

        if (Math.abs(car.getPosition()[0] - position[0]) <= 25 &&
                Math.abs(car.getPosition()[1] - position[1]) <= 25) {
                    storedCars[carIndex] = car;
                    storedCars[carIndex].setPosition(position);
                    car.stopEngine();
                    carIndex++;
                    System.out.println("Stored car");
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

    protected void unloadSpecificCar (T car, double[] position){
        int ind = 0;
        for(T c:storedCars) {
            if (car == c) {
                storedCars[ind].setPosition(new double[] {position[0], position[1]});
                storedCars[ind] = null;
                return;
            }
            ind++;
        }
        throw new IllegalArgumentException("Car not stored");
    }

    public T[] getStoredCars() {
        return storedCars;
    }

    public int getMaxCars() {
        return maxCars;
    }

}