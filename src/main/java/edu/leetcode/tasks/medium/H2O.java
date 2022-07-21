package edu.leetcode.tasks.medium;

import java.util.concurrent.Semaphore;

public class H2O {

    Semaphore H = new Semaphore(2);
    Semaphore O = new Semaphore(1);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        H.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        if (H.availablePermits() == 0)
            O.release();
    }


    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        O.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        H.release(2);
    }


    public static void main(String[] args) {
        H2O h2o = new H2O();
        new Thread(()-> {
            try {
                h2o.hydrogen(()-> System.out.println("H"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(()-> {
            try {
                h2o.hydrogen(()-> System.out.println("H"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(()-> {
            try {
                h2o.hydrogen(()-> System.out.println("H"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

}
