package lesson5;

import java.util.concurrent.Semaphore;

public class SemaphoreApp {

    public static void main(String[] args) {
        /**
         * Семафор с 1 палочкой - обычный лок
         */

        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            int ii = i;
            new Thread(() -> {
                try {
                    System.out.println("Thread " + ii + " in front of semaphore");
                    semaphore.acquire();  // позволяет пропускать определенное кол-во потоков
                    System.out.println("Thread " + ii + " after semaphore");
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                } finally {
                    System.out.println("Thread " + ii + " released semaphore");
                    semaphore.release();  // отдает палочку, пропускает остальных


                }
            }).start();
        }


    }
}
