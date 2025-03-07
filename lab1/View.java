import javax.swing.*;
import java.util.ArrayList;

public interface View extends Observer {

        void drawComponents();
        void moveIt(ArrayList<String> carNames, ArrayList<double[]> position);
        int getX1();
        int getY1();
        int getPicHeight();
        int getPicWidth();
}
