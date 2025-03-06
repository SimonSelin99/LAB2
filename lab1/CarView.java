import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarView extends JFrame implements View{
    private static final int X = 800;
    private static final int Y = 800;
    CarController carC;
    DrawPanel drawPanel = new DrawPanel(X, Y-240);
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

    public CarView(String framename, CarController carC){
        this.carC = carC;
        initComponents(framename);
    }




    private void initComponents(String title) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.add(drawPanel);
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });
        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        this.add(gasPanel);
        controlPanel.setLayout(new GridLayout(2,4));
        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(addCar, 6);
        controlPanel.add(removeCar, 7);

        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);
        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);

        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.gas(gasAmount);
            }

        });

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.brake(gasAmount);
            }

        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.stopEngine();
            }

        });

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.turboOff();
            }

        });

        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.turboOn();
            }

        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.startEngine();
            }

        });

        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.liftBed();
            }

        });

        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.lowerBed();
            }

        });
        addCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.addCar();
            }

        });
        removeCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.removeCar();
            }

        });

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
    public void moveIt(ArrayList<Car> cars) {
        drawPanel.moveit(cars);
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