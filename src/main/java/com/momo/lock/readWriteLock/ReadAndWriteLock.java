package com.momo.lock.readWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 */
public class ReadAndWriteLock {

    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final ReadAndWriteLock lock = new ReadAndWriteLock();

        new Thread(){
            @Override
            public void run() {
                lock.get(Thread.currentThread());
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                lock.get(Thread.currentThread());
            }
        }.start();
    }

    public void get(Thread thread){
        rwl.readLock().lock();
        try{
            long start = System.currentTimeMillis();

            while (System.currentTimeMillis() - start <= 1){
                System.out.println(thread + "正在进行读操作");
            }
            System.out.println(thread.getName() + "读操作完毕");
        }finally {
            rwl.readLock().unlock();
        }
    }

}
