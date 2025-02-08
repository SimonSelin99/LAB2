abstract public class Truckbed extends Car {
    private int angle = 0;
    protected void setTruckBed(int angle) {
        if (getCurrentSpeed() == 0) {
            this.angle = Math.max(Math.min(this.angle + angle, 70), 0);
        }
    }
    protected void setTruckBed(boolean rampUp){
        if(rampUp) {
            setTruckBed(-100);
        }
        else {
            setTruckBed(100);
        }
    }

    public int getTruckbed(){return this.angle;}
}
