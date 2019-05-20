package com.momo.synchronizedd.wait_notify_notifyall.one;

import java.util.concurrent.TimeUnit;

public class Temp {

    int count = 1;

    public void waiter() throws InterruptedException {
        synchronized (this){
            System.out.println("等待");
            wait();
            System.out.println(this.count);
        }
    }

    public void notifyer() throws InterruptedException {
        synchronized (this){
            //这里睡眠1s是为了让waiter（）先执行
            TimeUnit.SECONDS.sleep(1);
            System.out.println("唤醒");
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread() + "notify:" + i);
                count += i;
            }
            notify();  //唤醒上面的wait（）,后面的输出才会执行
        }
    }
}
