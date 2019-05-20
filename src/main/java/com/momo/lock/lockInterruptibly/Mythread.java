package com.momo.lock.lockInterruptibly;


import java.util.concurrent.ThreadPoolExecutor;

public class Mythread  extends Thread{

    private LockInterruptibly interruptibly = null;

    public Mythread(LockInterruptibly interruptibly){
        this.interruptibly = interruptibly;
    }

    @Override
    public void run() {
        try {
            interruptibly.insert(Thread.currentThread());
        } catch (InterruptedException e) {
            System.out.println("因为线程Thread2被中断了，所以insert()方法也就停止执行，中断标志发生变化，抛出中断异常");
            System.out.println(Thread.currentThread().getName() + "被中断");
        }
    }
}
