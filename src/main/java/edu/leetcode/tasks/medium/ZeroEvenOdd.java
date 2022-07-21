package edu.leetcode.tasks.medium;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private int evenLoops;
    private int oddLoops;

    private Semaphore zeroSemaphore = new Semaphore(1);
    private Semaphore evenSemaphore = new Semaphore(0);
    private Semaphore oddSemaphore = new Semaphore(0);

    private AtomicInteger counter = new AtomicInteger(1);

    public ZeroEvenOdd(int n) {
        this.n = n;
        if (n % 2 == 0) {
            evenLoops = n / 2;
            oddLoops = evenLoops;
        } else {
            evenLoops = n / 2 + 1;
            oddLoops = n / 2;
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroSemaphore.acquire();
            printNumber.accept(0);
            if (i % 2 == 1) {
                evenSemaphore.release();
                zeroSemaphore.acquire();
            } else {
                oddSemaphore.release();
                zeroSemaphore.acquire();
            }
            zeroSemaphore.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < evenLoops; i++) {
            evenSemaphore.acquire();
            printNumber.accept(counter.getAndIncrement());
            zeroSemaphore.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < oddLoops; i++) {
            oddSemaphore.acquire();
            printNumber.accept(counter.getAndIncrement());
            zeroSemaphore.release();
        }
    }

    public static void main(String[] args) {
        IntConsumer consumerZ = (i) -> {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " " + i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        IntConsumer consumerE = (i) -> {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " " + i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        IntConsumer consumerO = (i) -> {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " " + i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        ZeroEvenOdd z = new ZeroEvenOdd(5);
        Thread zt = new Thread(() -> {
            try {
                Thread.sleep(1000);
                z.zero(consumerZ);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        zt.setName("zero");
        zt.start();
        Thread ze = new Thread(() -> {
            try {
                Thread.sleep(11);
                z.even(consumerE);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        ze.setName("even");
        ze.start();
        Thread to = new Thread(() -> {
            try {
                z.odd(consumerO);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        to.setName("odd");
        to.start();
    }
}