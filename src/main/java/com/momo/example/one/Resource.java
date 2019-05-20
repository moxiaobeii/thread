package com.momo.example.one;

//多生产多消费
public class Resource {   //将共有资源封装

    private String name;
    private int count = 1;
    private boolean flag = false;

    public synchronized void set(String name){ //同步set方法
        if (flag){ //如果为假，生产烤鸭，如果为真，等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name + count;
        count ++;
        System.out.println(Thread.currentThread().getName() + ",生产者..."  + this.name);
        flag = true;
        notifyAll();   //防止死锁问题，唤醒线程池中的所有线程
    }
    public synchronized void out(){  //同步out方法
        if (!flag){ //如果为假，生产烤鸭，如果为真，等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "...消费者" + this.name);
        flag = false;
        notifyAll();
    }


}
