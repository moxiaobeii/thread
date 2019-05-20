package com.momo.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//多生产多消费
public class Resource {   //将共有资源封装

    private String name;
    private int count = 1;
    private boolean flag = false;

    Lock lock=new ReentrantLock();
    Condition con=lock.newCondition();
    Condition pro=lock.newCondition();

    public synchronized void set(String name){ //同步set方法

        lock.lock();
        try{
            if (flag){ //如果为假，生产烤鸭，如果为真，等待
                try {
                    pro.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.name = name + count;
            count ++;
            System.out.println(Thread.currentThread().getName() + ",生产者..."  + this.name);
            flag = true;
            con.signal();//防止死锁问题，唤醒线程池中的全部线程
        }finally {
            lock.unlock();
        }

    }
    public synchronized void out(){  //同步out方法
        lock.lock();
        try {
            if (!flag){ //如果为假，生产烤鸭，如果为真，等待
                try {
                    con.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "...消费者" + this.name);
            flag = false;
            pro.signal();
        }finally {
            lock.unlock();
        }

    }
}
