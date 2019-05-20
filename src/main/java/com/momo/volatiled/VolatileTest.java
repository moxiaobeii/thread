package com.momo.volatiled;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {
    private static AtomicInteger race = new AtomicInteger(0);
    private static synchronized void increase(){
//        race++;    //不是原子操作
        race.getAndIncrement();   //原子操作
    }
    private static final int THREAD_COUNT  = 20;
    public static void main(String[] args){
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        System.out.println(race);
    }

}
