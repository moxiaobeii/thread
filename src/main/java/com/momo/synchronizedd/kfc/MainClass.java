package com.momo.synchronizedd.kfc;

//主函数
public class MainClass {

    //生产者消费者模式
    public static void main(String[] args) {
        // 只实例化一个KFC对象，保证每一个服务员和用户在同一个KFC对象内
        KFC kfc = new KFC();

        //实例化4个客户对象
        Customer customer1 = new Customer(kfc);
        Customer customer2 = new Customer(kfc);
        Customer customer3 = new Customer(kfc);
        Customer customer4 = new Customer(kfc);

        //实例化3个服务员对象
        Waiter waiter1 = new Waiter(kfc);
        Waiter waiter2 = new Waiter(kfc);
        Waiter waiter3 = new Waiter(kfc);

        waiter1.start();
        waiter3.start();
        waiter2.start();

        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();
    }
}
