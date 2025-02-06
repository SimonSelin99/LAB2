import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static java.lang.String.valueOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testvolvo240 {
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
        assertTrue(testVolvo.getNrDoors()==4);
    }
    @Test
    public void testColor() {assertTrue(testVolvo.getColor()== Color.black);}
    @Test
    public void testEnginePower() {
        assertTrue(testVolvo.getEnginePower()==100);
    }
    @Test
    public void testModelName() {assertTrue(testVolvo.getModelName() == "Volvo240");}
    @Test
    public void testDirection() {assertTrue(testVolvo.getCurrentDirection() == car.Direction.UP);}
    @Test
    public void testPosition() {assertTrue(Arrays.equals(testVolvo.getPosition(), new double[] {0,0}));}
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
        assertEquals(testVolvo.getCurrentDirection() , car.Direction.LEFT);
    }
    @Test
    public void testTurnRight(){
        testVolvo.turnRight();
        assertEquals(testVolvo.getCurrentDirection() , car.Direction.RIGHT);
    }
    @Test
    public void testStopEngine(){
        testVolvo.stopEngine();
        assertEquals(0,testVolvo.getCurrentSpeed(),0.01);
    }
}
