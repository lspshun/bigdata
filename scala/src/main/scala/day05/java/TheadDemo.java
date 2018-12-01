package day05.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TheadDemo {

    public static void main(String[] args) {
        // TODO Java中的线程池 - 复用
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        /*for (int i = 0;i < 5;i ++){
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "-" + Thread.currentThread().getId());
                    try {
                        Thread.sleep(3000);
                    }catch (Exception e){

                    }
                }
            });
        }
        for (int i = 0;i < 10;i ++){
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "-" + Thread.currentThread().getId());
                    try {
                        Thread.sleep(3000);
                    }catch (Exception e){

                    }
                }
            });
        }*/
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0;i < 5;i ++){
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "-" + Thread.currentThread().getId());
                    try {
                        Thread.sleep(3000);
                    }catch (Exception e){

                    }
                }
            });
        }
        try {
            Thread.sleep(3500);
        }catch (Exception e){

        }
        for (int i = 0;i < 10;i ++){
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "-" + Thread.currentThread().getId());
                    try {
                        Thread.sleep(3000);
                    }catch (Exception e){

                    }
                }
            });
        }
        cachedThreadPool.shutdown();
    }
}
