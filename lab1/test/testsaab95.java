import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testsaab95 {
    public Saab95 testSaab;
    @Before
    public void setUp() {
        testSaab = new Saab95();
        testSaab.startEngine();
        testSaab.setTurboOff();
    }
    @After
    public void after() {
        testSaab.stopEngine();
    }
    @Test
    public void testDoors() {
        assertTrue(testSaab.getNrDoors()==2);
    }

    @Test
    public void testGasNegative() {
        double speed = testSaab.getCurrentSpeed();
        testSaab.gas(-0.5);
        assertEquals(speed , testSaab.getCurrentSpeed(),0.01);
    }

    @Test
    public void testGasBig() {
        double speed = testSaab.getCurrentSpeed();
        testSaab.gas(2.0);
        assertEquals(speed + 1.25 , testSaab.getCurrentSpeed(), 0.001);
    }
    @Test
    public void testGasTurbo() {
        double speed = testSaab.getCurrentSpeed();
        testSaab.setTurboOn();
        testSaab.gas(1);
        assertEquals(speed + 1.625 , testSaab.getCurrentSpeed(), 0.001);

    }
    @Test
    public void testBrakeBig() {
        double speed = testSaab.getCurrentSpeed();
        testSaab.brake(2.0);
        assertEquals(Math.max(speed - 1.25, 0) , testSaab.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testBrakeNegative() {
        double speed = testSaab.getCurrentSpeed();
        testSaab.brake(-0.5);
        assertEquals(speed , testSaab.getCurrentSpeed(), 0.01);
    }
    @Test
    public void testMove(){
        double[] pos = testSaab.getPosition();
        testSaab.move();
        assertEquals(pos[1],testSaab.getCurrentSpeed(), 0.001);
    }
    @Test
    public void testTurnLeft(){
        testSaab.turnLeft();
        assertEquals(testSaab.getCurrentDirection() , car.Direction.LEFT);
    }
    @Test
    public void testTurnRight(){
        testSaab.turnRight();
        assertEquals(testSaab.getCurrentDirection() , car.Direction.RIGHT);
    }
    @Test
    public void testStopEngine(){
        testSaab.stopEngine();
        assertEquals(0,testSaab.getCurrentSpeed(),0.01);
    }
}
