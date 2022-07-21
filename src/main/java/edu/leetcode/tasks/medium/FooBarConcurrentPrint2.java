package edu.leetcode.tasks.medium;

import java.util.concurrent.Semaphore;

public class FooBarConcurrentPrint2 {
    private int n;
    private Semaphore sFoo, sBar;

    public FooBarConcurrentPrint2(int n) {
        this.n = n;
        sFoo = new Semaphore(1);
        sBar = new Semaphore(1);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            sBar.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            sFoo.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        sFoo.acquire();
        for (int i = 0; i < n; i++) {
            sFoo.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            sBar.release();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        FooBarConcurrentPrint2 fb = new FooBarConcurrentPrint2(10);
        Runnable f = () -> System.out.print("foo");
        Runnable b = () -> System.out.print("bar");
        new Thread(() -> {
            try {
                Thread.sleep(400);
                fb.bar(b);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        Thread.sleep(400);
        new Thread(() -> {
            try {
                fb.foo(f);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
