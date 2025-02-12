import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestTransport {
    public Transport testTransport;
    public Transport testTransportO;

    public Volvo240 tTestVolvo240;
    public Saab95 tTestSaab95;
    public Scania tTestScania;
    @Before
    public void setUp() {
        testTransport = new Transport(new SmallCar[5]);
        testTransportO = new Transport(new SmallCar[1]);

        tTestSaab95 = new Saab95();
        tTestVolvo240 = new Volvo240();
        tTestScania = new Scania();
        testTransport.startEngine();
    }
    @Test
    public void incbed(){
        testTransport.setTruckBed(false);
        assertEquals(true,testTransport.getRampUp());
    }
    @Test
    public void incbedstill(){
        testTransport.stopEngine();
        testTransport.setTruckBed(false);
        assertEquals(false,testTransport.getRampUp());
    }

    @Test
    public void decbed(){
        testTransport.stopEngine();
        testTransport.setTruckBed(false);
        testTransport.setTruckBed(true);
        assertEquals(true,testTransport.getRampUp());
    }
   @Test
   public void loadCar(){
        testTransport.stopEngine();
        testTransport.setTruckBed(false);
        testTransport.loadCar(tTestSaab95);
        assertEquals(testTransport.getStoredCars()[0], tTestSaab95);
   }
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void overloadCar(){
        testTransportO.stopEngine();
        testTransportO.setTruckBed(false);
        testTransportO.loadCar(tTestSaab95);
        testTransportO.loadCar(tTestVolvo240);

    }
    @Test
    public void rampUpLoad(){
        testTransport.setTruckBed(true);
        testTransport.loadCar(tTestSaab95);
        assertNull(testTransport.getStoredCars()[0]);

    }
    @Test
    public void carPosBefore(){
        testTransport.stopEngine();
        testTransport.setTruckBed(false);
        testTransport.loadCar(tTestSaab95);
        testTransport.startEngine();
        testTransport.move();
        assertEquals(testTransport.getPosition()[1], tTestSaab95.getPosition()[1],0.01);
    }
    @Test
    public void carPosAfter(){
        testTransport.stopEngine();
        testTransport.setTruckBed(false);
        testTransport.loadCar(tTestSaab95);
        testTransport.setTruckBed(true);
        testTransport.startEngine();
        testTransport.move();
        testTransport.stopEngine();
        testTransport.setTruckBed(false);
        testTransport.unLoadCar(1);
        testTransport.setTruckBed(true);
        testTransport.startEngine();
        testTransport.move();
        assertEquals(testTransport.getPosition()[1] - 0.1, tTestSaab95.getPosition()[1],0.01);
    }

    @Test
    public void unLoadCar(){
        testTransport.stopEngine();
        testTransport.setTruckBed(false);
        testTransport.loadCar(tTestVolvo240);
        testTransport.loadCar(tTestSaab95);
        testTransport.unLoadCar(1);
        assertTrue(tTestVolvo240 == testTransport.getStoredCars()[0] &&
                testTransport.getStoredCars()[1] == null);
    }

    @After
    public void after() {
        testTransport.stopEngine();
        testTransport.setTruckBed(false);
        testTransport.unLoadCar(5);

    }
}
