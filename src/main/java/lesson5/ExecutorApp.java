package lesson5;

import java.beans.FeatureDescriptor;
import java.util.concurrent.*;

public class ExecutorApp {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();
        ExecutorService fixedExecutorService = Executors.newFixedThreadPool(10);
//        ExecutorService cashedExecutorService = Executors.newCachedThreadPool();  //сначала один, потом по мере небходимости расширяется

        fixedExecutorService.execute(() -> System.out.println("abc"));                // возвращает войд
        Future<?> abc = fixedExecutorService.submit(() -> System.out.println("abc")); //возвращает обьект (Callable)
        Future<String> submit = fixedExecutorService.submit(() -> "Callable String");
        Object o = abc.get();
        String s = submit.get();  //ожидай 5 сек результата

        Future<Integer> intFuture = fixedExecutorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 10/0;
            }
        });
        try {
            Integer integer = intFuture.get();
        } catch (ExecutionException ex) {
//            ex.printStackTrace();
            ex.getCause().printStackTrace();  //вытаскивание причины
            throw new RuntimeException(ex.getCause());
        }

        fixedExecutorService.shutdown();


    }
}
