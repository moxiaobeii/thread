package com.momo.synchronizedd.atm;

public class PersonB extends Thread{

    //创建银行对象(静态代码块)
    private Bank bank;

    //通过构造器传入银行对象，确保两个人进入的是一个银行
    public PersonB(Bank bank){
        this.bank = bank;
    }

    //在里面实现使用柜台取钱
    @Override
    public void run() {
        while (Bank.money >= 200){
            bank.atm(200);
        }
    }
}
