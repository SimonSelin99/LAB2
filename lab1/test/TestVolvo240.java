import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestVolvo240 {
    public Volvo240 testVolvo;
    @Before
    public void setUp() {
        testVolvo = new Volvo240();
        testVolvo.startEngine();

    }
    @After
    public void after() {
        testVolvo.stopEngine();
    }
    @Test
    public void testDoors() {
        assertEquals(testVolvo.getNrDoors(),4);
    }
    @Test
    public void testColor() {assertEquals(Color.black,testVolvo.getColor());}
    @Test
    public void testEnginePower() {
        assertEquals(100,testVolvo.getEnginePower(),0.01);
    }
    @Test
    public void testModelName() {assertEquals("Volvo240",testVolvo.getModelName());}
    @Test
    public void testDirection() {assertEquals(Car.Direction.UP,testVolvo.getCurrentDirection());}
    @Test
    public void testPosition() {assertArrayEquals(new double[]{0, 0}, testVolvo.getPosition(), 0.0);}
    @Test
    public void testGasNegative() {
        double speed = testVolvo.getCurrentSpeed();
        testVolvo.gas(-0.5);
        assertEquals(speed , testVolvo.getCurrentSpeed(),0.01);
    }

    @Test
    public void testGasBig() {
        double speed = testVolvo.getCurrentSpeed();
        testVolvo.gas(2.0);
        assertEquals(speed + 1.25 , testVolvo.getCurrentSpeed(), 0.01);
    }
    @Test
    public void testBrakeBig() {
        double speed = testVolvo.getCurrentSpeed();
        testVolvo.brake(2.0);
        assertEquals(Math.max(speed - 1.25, 0) , testVolvo.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testBrakeNegative() {
        double speed = testVolvo.getCurrentSpeed();
        testVolvo.brake(-0.5);
        assertEquals(speed , testVolvo.getCurrentSpeed(), 0.01);
    }
    @Test
    public void testMove(){
        double[] pos = testVolvo.getPosition();
        testVolvo.move();
        assertEquals(pos[1],testVolvo.getCurrentSpeed(), 0.001);
    }
    @Test
    public void testTurnLeft(){
        testVolvo.turnLeft();
        assertEquals(testVolvo.getCurrentDirection() , Car.Direction.LEFT);
    }
    @Test
    public void testTurnRight(){
        testVolvo.turnRight();
        assertEquals(testVolvo.getCurrentDirection() , Car.Direction.RIGHT);
    }
    @Test
    public void testStopEngine(){
        testVolvo.stopEngine();
        assertEquals(0,testVolvo.getCurrentSpeed(),0.01);
    }
}
