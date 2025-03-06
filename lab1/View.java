import java.util.ArrayList;

public interface View {
        DrawPanel drawPanel = null;
        void drawComponents();
        void moveIt(ArrayList<Car> cars);
        int getX1();
        int getY1();
        int getPicHeight();
        int getPicWidth();

}
