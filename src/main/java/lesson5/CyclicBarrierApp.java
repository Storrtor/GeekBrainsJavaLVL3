package lesson5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierApp {

    public static void main(String[] args) {
        int threadCount = 5;
        // 5 потоков взаимодействуют с барьером и начинаем дальше
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadCount);
        for (int i = 0; i < threadCount; i++) {
            int ii = i;
            new Thread(() -> {
                try {
                    System.out.println("Thread " + ii + " is getting ready");
                    Thread.sleep(2000 + 500 * ii);
                    System.out.println("Thread " + ii + " is ready");
                    cyclicBarrier.await();  //блокирует наш поток пока не набьется 5 взаимодействий
                    System.out.println("Thread  " + ii + " is running");
                    Thread.sleep(2000 + 500 * ii);
                    cyclicBarrier.await();
                    System.out.println("Thread  " + ii + " is finished");
                    cyclicBarrier.await();
                    System.out.println("All Finished");
                } catch (InterruptedException | BrokenBarrierException ex) {
                    ex.printStackTrace();
                }

            }).start();
        }

    }
}
