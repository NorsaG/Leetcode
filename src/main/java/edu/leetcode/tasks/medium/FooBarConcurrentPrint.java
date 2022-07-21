package edu.leetcode.tasks.medium;

/**
 * 2022-04-15
 */
class FooBarConcurrentPrint {
    private int n;
    private volatile boolean isFooOrder = true;

    public FooBarConcurrentPrint(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                if (!isFooOrder)
                    this.wait();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                isFooOrder = false;
                this.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        synchronized (this) {
            if (isFooOrder) {
                this.wait();
            }
        }
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                if (isFooOrder)
                    this.wait();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                isFooOrder = true;
                this.notifyAll();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        FooBarConcurrentPrint fb = new FooBarConcurrentPrint(1000);
        Runnable f = () -> System.out.print("foooooo");
        Runnable b = () -> System.out.print("baaaaar");
        new Thread(() -> {
            try {
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