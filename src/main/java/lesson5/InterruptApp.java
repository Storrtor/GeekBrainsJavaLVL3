package lesson5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InterruptApp {

    public static void main(String[] args) throws InterruptedException {
        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        Thread.sleep(1500);
        thread.interrupt();

    }

    /**
     * Можно выключить через переменную
     * Можно выключить через интерапт
     */

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
//            boolean interrupted = false;
            for (int i = 0; i < 10; i++) {
                if (Thread.currentThread().isInterrupted()){
                    break;
                }
                System.out.println(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
//                    interrupted = true;
                }
            }
        }

    }


}
