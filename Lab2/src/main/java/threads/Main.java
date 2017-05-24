package threads;

import java.util.concurrent.*;

/**
 * Created by nicol on 31.03.2017.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        ExecutorService service = new ScheduledThreadPoolExecutor(2);

        for(int i=0; i < 2; i++) {
            service.submit(new Process(i+1, countDownLatch));
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Process p = new Process(3, new CountDownLatch(1));
        p.run();
        service.shutdown();
        service.awaitTermination(1, TimeUnit.DAYS);
    }
}
