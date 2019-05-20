package com.momo.lock.lockInterruptibly;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptibly  {

    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        LockInterruptibly test = new LockInterruptibly();

        Mythread mythread1 = new Mythread(test);
        Mythread mythread2 = new Mythread(test);

        mythread1.start();
        mythread2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mythread2.interrupt();
    }

    public void insert(Thread thread) throws InterruptedException {
        lock.lockInterruptibly();  //注意，如果要正确中断等待中的线程，必须将获取
        //锁放在外面，然后将InterruptedException抛出
        try{
            System.out.println(thread.getName() + "得到了锁");
            long startTime = System.currentTimeMillis();
            for (; ;) {
                if (System.currentTimeMillis()-startTime >= 10000){
                    break;
                }
            }
        }finally {
            System.out.println(Thread.currentThread().getName() + "执行finally");
            lock.unlock();
            System.out.println(thread.getName() + "释放了锁");
        }

    }

}
