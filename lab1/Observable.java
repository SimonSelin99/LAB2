import java.util.ArrayList;
import java.util.List;

public class Observable {

    private List <Observer> observers = new ArrayList<>();
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
    public void ping(ArrayList<String> carName, ArrayList<double[]> position) {
        for (Observer o : observers) {
            o.actOnSignal(carName,position  );
        }
    }

}
