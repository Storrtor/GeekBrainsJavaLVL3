package lesson5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockApp {

    // тот же поток повторно может брать этот лок - это ок
    static Lock lock = new ReentrantLock();  //повторно используемый лок

    static List<String> list = new ArrayList<>();

    /**
     * !!!
     * Лок в отличии от синхроайзд метода может браться в одном месте,
     * осовбождаться в другом
     */

    public static void main(String[] args) throws InterruptedException {
//        lock.lock();  работает как синхронайзд
//        lock.unlock(); освобождает лок
//        while (!lock.tryLock()) {
//            System.out.println("Still waiting");
//            Thread.sleep(900);
//        }

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() ->{
            write();
            checkAndRelease();
        });
        executorService.submit(() ->{
            write();
            checkAndRelease();
        });
        executorService.submit(() ->{
            write();
            checkAndRelease();
        });
        executorService.shutdown();


    }

    static void write() {
        System.out.println("TryTOGet = " + lock.tryLock());
        lock.lock();
        list.add("String");
    }

    static void checkAndRelease() {
        System.out.println(list.contains("String"));
        lock.unlock();
    }
}
