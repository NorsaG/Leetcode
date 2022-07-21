package edu.leetcode.tasks.easy;

import java.security.SecureRandom;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * 2022-04-14
 */
public class OrderPrinting {
    private CountDownLatch complete1 = new CountDownLatch(1);
    private CountDownLatch complete2 = new CountDownLatch(1);

    public OrderPrinting() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();

        complete1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        complete1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        complete2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        complete2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) {
        OrderPrinting o = new OrderPrinting();
        Runnable r1 = () -> {
            try {
                Thread.sleep(new SecureRandom().nextInt(100));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("first");
        };
        Runnable r2 = () -> {
            try {
                Thread.sleep(new SecureRandom().nextInt(100));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("second");
        };
        Runnable r3 = () -> {
            try {
                Thread.sleep(new SecureRandom().nextInt(100));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("third");
        };

        startFirstThread(o, r1);
        startSecondThread(o, r2);
        startThirdThread(o, r3);
    }

    private static void startFirstThread(OrderPrinting o, Runnable r1) {
        new Thread(() -> {
            try {
                o.first(r1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    private static void startSecondThread(OrderPrinting o, Runnable r1) {
        new Thread(() -> {
            try {
                o.second(r1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    private static void startThirdThread(OrderPrinting o, Runnable r1) {
        new Thread(() -> {
            try {
                o.third(r1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
