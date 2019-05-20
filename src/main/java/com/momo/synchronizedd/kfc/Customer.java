package com.momo.synchronizedd.kfc;

//创建一个客户类Customer
public class Customer extends Thread{

    //KFC要传入，保证每一个服务员和用户在同一个KFC对象内
    KFC kfc;
    public Customer(KFC kfc){
        this.kfc = kfc;
    }

    @Override
    public void run() {
        int size = (int) (Math.random() * 5);  //每次要消费的食物的数量
        while (true){
            kfc.consu(size);
        }
    }
}
