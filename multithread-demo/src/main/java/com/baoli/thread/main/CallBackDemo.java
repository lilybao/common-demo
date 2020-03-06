package com.baoli.thread.main;

public class CallBackDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread());
        thread.start();
    }
}
