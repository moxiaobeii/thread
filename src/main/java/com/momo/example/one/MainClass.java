package com.momo.example.one;

public class MainClass {

    public static void main(String[] args) {

        Resource resource = new Resource();

        Produce produce = new Produce(resource);
        Consumer consumer = new Consumer(resource);

        Thread thread1 = new Thread(produce);
        Thread thread2 = new Thread(produce);
        Thread thread3 = new Thread(consumer);
        Thread thread4 = new Thread(consumer);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
