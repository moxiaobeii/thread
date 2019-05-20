package com.momo.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

//通过锁和cas实现原子操作
public class Counter {

    private AtomicInteger atomicI = new AtomicInteger(0);
    private static int i = 0;

    public static void main(String[] args) {
        final Counter cas = new Counter();
        List<Thread> ts = new ArrayList<Thread>(600);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        cas.count();
                        cas.safeCount();
                    }
                }
            });
            ts.add(t);
        }
        for (Thread t : ts){
            t.start();
        }

        //等待所有线程执行完
        for (Thread t : ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(cas.i);
        System.out.println(cas.atomicI.get());
        System.out.println(System.currentTimeMillis()-start);
    }

    //使用cas实现线程安全计数器
    private void safeCount() {
        for (;;){
            int i = atomicI.get();
            boolean  suc = atomicI.compareAndSet(i,++i);
            if (suc){
                break;
            }
        }
    }

    //非线程计数器
    private synchronized void count() {
        i ++;
    }
}
