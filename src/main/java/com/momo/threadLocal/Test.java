package com.momo.threadLocal;

/**
 * threadLocal
 *
 * 证明通过ThreadLocal能达到在每个线程中创建变量副本的效果：
 */
public class Test {
    ThreadLocal<Long> longThreadLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringThreadLocal = new ThreadLocal<String>();

    public void set(){
        longThreadLocal.set(Thread.currentThread().getId());
        stringThreadLocal.set(Thread.currentThread().getName());
    }

    public long getLong(){
        return longThreadLocal.get();
    }

    public String getString(){
        return stringThreadLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final Test test = new Test();
        test.set();

        System.out.println("Long:" + test.getLong());
        System.out.println("String:" + test.getString());

        Thread thread = new Thread(){
            @Override
            public void run() {
                test.set();
                System.out.println("LongI:" + test.getLong());
                System.out.println("StringI:" + test.getString());
            }
        };
        thread.start();
        thread.join();
        System.out.println("LongO:" + test.getLong());
        System.out.println("StringO:" + test.getString());
    }
}
