package com.momo.synchronizedd.atm;

public class Bank {

    //假设银行账户有1000元
    static int money = 20000;

    //柜台Counter取钱的方法
    public synchronized void counter(int money){
        Bank.money -= money;
        System.out.println("A取走了" + money + "元，还剩下" + Bank.money);
    }

    //ATM取钱的方法
    public synchronized void atm(int money){
        Bank.money -= money;
        System.out.println("B取走了" + money + "元，还剩下" + Bank.money);
    }
}
