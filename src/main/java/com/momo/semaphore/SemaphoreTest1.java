package com.momo.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *   我们可以启动几十个线程
     并发地读取，但是如果读到内存后，还需要存储到数据库中，而数据库的连接数只有10个，这
     时我们必须控制只有10个线程同时获取数据库连接保存数据，否则会报错无法获取数据库连
     接。这个时候，就可以使用Semaphore来做流量控制
 */
public class SemaphoreTest1 {

    private static final int THREAD_COUNT = 30;
    private static ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        s.acquire();
                        System.out.println("save data");
                        s.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        pool.shutdown();
    }
}
