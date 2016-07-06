package ua.goit.java.module3_2.square.sum;

import java.util.concurrent.Callable;
import java.util.concurrent.Phaser;

class Calculating implements Callable<Long> {
    private final int[] values;
    private final int numberOfThreads;
    private final Phaser phaser;
    private final int partOfArray;

    Calculating(int[] values, int numberOfThreads, Phaser phaser, int partOfArray) {
        this.values = values;
        this.numberOfThreads = numberOfThreads;
        this.phaser = phaser;
        this.partOfArray = partOfArray;
        phaser.register();
    }

    @Override
    public Long call() throws Exception {
        String threadName = Thread.currentThread().getName();
        System.out.println("Thread " + threadName + " started.");
        phaser.arriveAndAwaitAdvance();
        Thread.sleep(500);

        long squareSum = computeSquares();
        System.out.println("Thread " + threadName + " is waiting.");
        phaser.arriveAndAwaitAdvance();
        Thread.sleep(500);

        System.out.println("Thread " + threadName + "returns " + squareSum + " value.");
        phaser.arriveAndDeregister();

        return squareSum;
    }

    long computeSquares() {
        long squaresSum = 0;
        int firstIndex = partOfArray * (values.length / numberOfThreads);
        int lastIndex;
        boolean isLastPart = partOfArray + 1 == numberOfThreads;

        if (isLastPart) {
            lastIndex = values.length;
        } else {
            lastIndex = firstIndex + (values.length / numberOfThreads);
        }

        while (firstIndex < lastIndex) {
            squaresSum += Math.pow(values[firstIndex], 2);
            firstIndex++;
        }

        return squaresSum;
    }
}
