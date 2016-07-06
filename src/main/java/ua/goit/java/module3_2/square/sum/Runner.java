package ua.goit.java.module3_2.square.sum;

public class Runner {
    public static void main(String[] args) {
        PhaserImpl phaser = new PhaserImpl();
        int[] values = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        long result = phaser.getSquareSum(values, 4);
        System.out.println("Result: " + result);
    }
}
