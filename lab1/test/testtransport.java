import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class testtransport {
    public Transport testTransport;
    public Transport testTransportO;

    public Volvo240 tTestVolvo240;
    public Saab95 tTestSaab95;
    public Scania tTestScania;
    @Before
    public void setUp() {
        testTransport = new Transport(5,new String[] {"Volvo240","Saab95"});
        testTransportO = new Transport(1,new String[] {"Volvo240","Saab95"});

        tTestSaab95 = new Saab95();
        tTestVolvo240 = new Volvo240();
        tTestScania = new Scania();
        testTransport.startEngine();
    }
    @Test
    public void incbed(){
        testTransport.setRamp(false);
        assertEquals(0,testTransport.getTruckbed());
    }
    @Test
    public void incbedstill(){
        testTransport.stopEngine();
        testTransport.setRamp(false);
        assertEquals(70,testTransport.getTruckbed());
    }
    @Test
    public void decbed(){
        testTransport.stopEngine();
        testTransport.setRamp(false);
        testTransport.setRamp(true);
        assertEquals(0,testTransport.getTruckbed());
    }
   @Test
   public void loadCar(){
        testTransport.stopEngine();
        testTransport.setRamp(false);
        testTransport.loadCar(tTestSaab95);
        assertEquals(testTransport.storeable.getStoredCars()[0], tTestSaab95);
   }
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void overloadCar(){
        testTransportO.stopEngine();
        testTransportO.setRamp(false);
        testTransportO.loadCar(tTestSaab95);
        testTransportO.loadCar(tTestVolvo240);

    }
    @Test
    public void rampUpLoad(){
        testTransport.setRamp(true);
        testTransport.loadCar(tTestSaab95);
        assertNull(testTransport.storeable.getStoredCars()[0]);

    }
    @Test
    public void carPosBefore(){
        testTransport.stopEngine();
        testTransport.setRamp(false);
        testTransport.loadCar(tTestSaab95);
        testTransport.startEngine();
        testTransport.move();
        assertEquals(testTransport.getPosition()[1], tTestSaab95.getPosition()[1],0.01);
    }
    @Test
    public void carPosAfter(){
        testTransport.stopEngine();
        testTransport.setRamp(false);
        testTransport.loadCar(tTestSaab95);
        testTransport.setRamp(true);
        testTransport.startEngine();
        testTransport.move();
        testTransport.stopEngine();
        testTransport.setRamp(false);
        testTransport.unLoadCar(1);
        testTransport.setRamp(true);
        testTransport.startEngine();
        testTransport.move();
        assertEquals(testTransport.getPosition()[1] - 0.1, tTestSaab95.getPosition()[1],0.01);
    }
    @Test(expected = IllegalArgumentException.class)
    public void loadTruckBed(){
        testTransport.loadCar(tTestScania);
    }
    @Test
    public void unLoadCar(){
        testTransport.stopEngine();
        testTransport.setRamp(false);
        testTransport.loadCar(tTestVolvo240);
        testTransport.loadCar(tTestSaab95);
        testTransport.unLoadCar(1);
        assertTrue(tTestVolvo240 == testTransport.storeable.getStoredCars()[0] &&
                testTransport.storeable.getStoredCars()[1] == null);
    }

    @After
    public void after() {
        testTransport.stopEngine();
        testTransport.setRamp(false);
        testTransport.unLoadCar(5);

    }
}
