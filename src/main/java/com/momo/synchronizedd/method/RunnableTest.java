package com.momo.synchronizedd.method;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableTest implements Runnable{

    //无序
    private synchronized void testSyncMethod1(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "getSyncMethod:" + i);
        }
    }

    //有序
    private void testSyncMethod2(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "getSyncMethod:" + i);
        }
    }

    //有序2
    private static synchronized void testSyncMethod3(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "getSyncMethod:" + i);
        }
    }

    @Override
    public void run(){
        testSyncMethod1();
        testSyncMethod2();
        testSyncMethod3();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(2);
        RunnableTest rt1 = new RunnableTest();
        RunnableTest rt2 = new RunnableTest();

        exec.execute(rt1);
        exec.execute(rt2);
        exec.shutdown();
    }

}
