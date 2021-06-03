package lesson4;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorApp {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        ExecutorService executorService1 = Executors.newSingleThreadExecutor();

        //        executorService.submit();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello executor");
            }
        });

        executorService.shutdown(); //доброе завершение сервиса, завершаются таски и завершение идет

    }
}
