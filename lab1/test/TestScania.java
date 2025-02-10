import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestScania {
    public Scania testScania;
    @Before
    public void setUp() {
        testScania = new Scania();
        testScania.startEngine();

    }
    @Test
    public void incbed(){
        testScania.incrementTruckBed(50);
        assertEquals(0,testScania.getAngle());
    }
    @Test
    public void incbedstill(){
        testScania.stopEngine();
        testScania.incrementTruckBed(50);
        assertEquals(50,testScania.getAngle());
    }
    @Test
    public void incbig(){
        testScania.stopEngine();
        testScania.incrementTruckBed(100);
        assertEquals(70,testScania.getAngle());
    }
    @Test
    public void decbig(){
        testScania.stopEngine();
        testScania.decrementTruckBed(100);
        assertEquals(0,testScania.getAngle());
    }
    @After
    public void after() {
        testScania.stopEngine();
    }

}
