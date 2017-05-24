package threads;

import java.util.concurrent.CountDownLatch;

/**
 * Created by nicol on 31.03.2017.
 */
public class Process implements Runnable{
    private CountDownLatch countDownLatch;
    private int thread;

    public Process(int nr, CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        this.thread = nr;
    }


    public void run() {

        System.out.println("Thread" + thread + " is starting ...");
        try {
            Thread.sleep((long) (thread * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread" + thread + " finished.");

        countDownLatch.countDown();
    }
}

