import javax.swing.*;
import java.util.ArrayList;

public interface View extends Observer {
        void addComponent(JButton button);

        void addComponent(JPanel panel);

        void drawComponents();
        void moveIt(ArrayList<String> carNames, ArrayList<double[]> position);
        int getX1();
        int getY1();
        int getPicHeight();
        int getPicWidth();
}
