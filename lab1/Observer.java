import java.util.ArrayList;

public interface Observer {
    void actOnSignal(ArrayList<String> carNames, ArrayList<double[]> position);
}
