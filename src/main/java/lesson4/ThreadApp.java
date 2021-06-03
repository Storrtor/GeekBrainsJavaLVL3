package lesson4;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.*;

public class ThreadApp {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable());
        Thread thread1 = new Thread(new MyRunnable());
        thread.start();
        thread1.start();
        out.println("from " + Thread.currentThread().getName());

        Thread thread2 = new MyThread();
        thread2.start();
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("from " + Thread.currentThread().getName());
            }
        });
        thread3.start();

        Thread thread4 = new Thread(() -> out.println("from labmda"));
        thread4.start();

        printDoubleString(new SimpleInterface() {
            @Override
            public String doubleString(String string) {
                return string + string;
            }
        }, "Hello");


        AtomicInteger intHolder = new AtomicInteger();  // CAS - Compare and Swap
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    intHolder.incrementAndGet(); //++i
//                    intHolder.getAndIncrement(); i++
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    intHolder.incrementAndGet();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        out.println(intHolder.get());



    }



    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            out.println("from " + Thread.currentThread().getName());
        }
    }

    private static class MyThread extends Thread {

    }

    public static void printDoubleString(SimpleInterface simpleInterface, String string) {
        out.println(simpleInterface.doubleString(string));
    }

    private static class IntHolder{
        int integer;

        public IntHolder(){
            this.integer = 0;
        }

        public int getInteger(){
            return integer;
        }

        public void increment() {
            integer = integer + 1;
        }


    }


}