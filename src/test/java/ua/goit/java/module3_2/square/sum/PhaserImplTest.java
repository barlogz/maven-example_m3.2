package ua.goit.java.module3_2.square.sum;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.Phaser;

public class PhaserImplTest {
    private int[] testValues = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    @Test
    public void testGetSquareSum() throws Exception {
        PhaserImpl phaser = new PhaserImpl();
        long result = phaser.getSquareSum(testValues, 4);
        long expected = 649;

        System.out.println("expected :" + expected);
        System.out.println("result:   " + result);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testComputeSquareIndex() throws Exception {
        Phaser phaser = new Phaser();
        Calculating calculating = new Calculating(testValues, 4, phaser, 0);
        long result = calculating.computeSquares();
        long expected = 13;

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testComputeSquareLastIndex() throws Exception {
        Phaser phaser = new Phaser();
        Calculating calculating = new Calculating(testValues, 4, phaser, 3);
        long result = calculating.computeSquares();
        long expected = 510;

        Assert.assertEquals(expected, result);
    }
}