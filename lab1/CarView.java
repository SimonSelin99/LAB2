import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CarView extends JFrame implements View,Observer {
    DrawPanel drawPanel;
    private final int X;
    private final int Y;
    /*
    JPanel controlPanel = new JPanel();
    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");
    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");
    JButton addCar = new JButton("Add random car");
    JButton removeCar = new JButton("Remove random car");


     */
    public CarView(String framename, DrawPanel drawPanel, int X, int Y){
        this.X = X;
        this.Y = Y;
        this.drawPanel = drawPanel;
        initComponents(framename);
    }
    @Override
    public void actOnSignal(ArrayList<String> carNames, ArrayList<double[]> position){
        moveIt(carNames,position);
        drawComponents();
    }
    @Override
    public void addComponent(JButton button) {
        this.add(button);
        this.pack();
    }
    @Override
    public void addComponent(JPanel panel) {
        this.add(panel);
        this.pack();
    }

    private void initComponents(String title) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.add(drawPanel);
        this.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void drawComponents() {
        drawPanel.repaint();
    }
    @Override
    public void moveIt(ArrayList<String> carNames, ArrayList<double[]> position) {
        drawPanel.moveit(carNames, position);
    }
    @Override
    public int getX1() {
        return drawPanel.getWidth();
    }
    @Override
    public int getY1() {
        return drawPanel.getHeight();
    }
    @Override
    public int getPicHeight() {
        return drawPanel.volvoImage.getHeight();
    }
    @Override
    public int getPicWidth() {
        return drawPanel.volvoImage.getWidth();
    }
}