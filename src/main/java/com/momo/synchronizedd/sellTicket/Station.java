package com.momo.synchronizedd.sellTicket;

/**
 * 站台卖票
 */
public class Station extends Thread{

    //通过构造方法给线程名字赋值
    public Station(String name){
        super(name);
    }

    //为了保持票数的一致性，票数要静态
    static int ticket = 20;

    //创建一个静态钥匙
    static Object ob = "aa";  //值是任意的

    //重写run方法，实现买票的操作
    @Override
    public void run() {
        while (ticket > 0){
            synchronized (ob){
                // 这个很重要，必须使用一个锁，
                // 进去的人会把钥匙拿在手上，出来后才把钥匙拿让出来
                if (ticket > 0){
                    System.out.println(getName() + "卖出了第" + ticket + "张票");
                    ticket --;
                }else {
                    System.out.println("票卖完了");
                }
                try{
                    sleep(1000);  //休息一秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
