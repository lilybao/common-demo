package com.baoli.leetcode.multiThread;

import java.util.concurrent.Semaphore;


public class Foo {
    private Semaphore semaphore_one_two = new Semaphore(0);
    private Semaphore semaphore_two_three = new Semaphore(0);

    public Foo() {
    }

    public void first(Runnable firstRunnable) throws InterruptedException {
        firstRunnable.run();
        semaphore_one_two.release();
    }

    public void second(Runnable secondRunnable) throws InterruptedException {
        semaphore_one_two.acquire();
        secondRunnable.run();
        semaphore_two_three.release();
    }

    public void third(Runnable thirdRunnable) throws InterruptedException {
        semaphore_two_three.acquire();
        thirdRunnable.run();
    }
}
