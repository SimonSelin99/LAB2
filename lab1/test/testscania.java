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

public class testscania {
    public Scania testScania;
    @Before
    public void setUp() {
        testScania = new Scania();
        testScania.startEngine();

    }
    @Test
    public void incbed(){
        testScania.incrementTruckbed(50);
        assertEquals(0,testScania.getTruckbed());
    }
    @Test
    public void incbedstill(){
        testScania.stopEngine();
        testScania.incrementTruckbed(50);
        assertEquals(50,testScania.getTruckbed());
    }
    @Test
    public void incbig(){
        testScania.stopEngine();
        testScania.incrementTruckbed(100);
        assertEquals(70,testScania.getTruckbed());
    }
    @Test
    public void decbig(){
        testScania.stopEngine();
        testScania.decrementTruckbed(100);
        assertEquals(0,testScania.getTruckbed());
    }
    @After
    public void after() {
        testScania.stopEngine();
    }

}
