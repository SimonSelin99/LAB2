import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class testmechanic {
    private Mechanic testMech;
    private Mechanic testMecho;
    private Volvo240 testVolvo240;
    private Saab95 testSaab95;
    private Scania testScania;
    @Before
    public void setUp() {
        testMech = new Mechanic(5,new String[] {"Volvo240", "Scania"},new double[]{0,0});
        testMecho = new Mechanic(1,new String[] {"Volvo240", "Scania"},new double[]{0,0});
        testSaab95 = new Saab95();
        testVolvo240 = new Volvo240();
        testScania = new Scania();
    }


    @Test
    public void loadCar(){
        testMech.loadCar(testVolvo240);
        assertEquals(testMech.storeable.getStoredCars()[0], testVolvo240);
    }
    @Test(expected = IllegalArgumentException.class)
    public void loadWrongCar(){
        testMech.loadCar(testSaab95);
    }
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void overloadCar(){
        testMecho.loadCar(testVolvo240);
        testMecho.loadCar(testScania);
    }

    @Test
    public void unLoadCar(){
        testMech.loadCar(testVolvo240);
        testMech.loadCar(testScania);
        testMech.getCar(testVolvo240);
        assertTrue(testMech.storeable.getStoredCars()[0]== null &&
                testMech.storeable.getStoredCars()[1] == testScania);
        //testTransport.storeable.getStoredCars()[0] == tTestVolvo240 );
    }

    }
