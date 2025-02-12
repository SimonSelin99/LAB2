import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestMechanic {
    private Mechanic testMech;
    private Mechanic testMecho;
    private Volvo240 testVolvo240;
    private Volvo240 testVolvo242;
    private Saab95 testSaab95;
    private Scania testScania;
    @Before
    public void setUp() {
        testMech = new Mechanic(new Volvo240[5],new double[]{0,0});
        testMecho = new Mechanic(new SmallCar[1],new double[]{0,0});
        testSaab95 = new Saab95();
        testVolvo240 = new Volvo240();
        testVolvo242 = new Volvo240();
        testScania = new Scania();
    }


    @Test
    public void loadCar(){
        testMech.loadCar(testVolvo240);
        assertEquals(testMech.getStoredCars()[0], testVolvo240);
    }
    @Test(expected = ArrayStoreException.class)
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
        testMech.loadCar(testVolvo242);
        testMech.getCar(testVolvo240);
        assertTrue(testMech.getStoredCars()[0]== null &&
                testMech.getStoredCars()[1] == testVolvo242);
    }

    }
