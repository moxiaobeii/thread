package com.momo.synchronizedd.atm;

public class PersonA extends Thread {

    //创建银行对象(静态代码块)
    private Bank bank;

    public PersonA(Bank bank){
        this.bank = bank;
    }

    //在里面实现使用柜台取钱
    @Override
    public void run() {
        while (Bank.money >= 100){
            bank.counter(100);
        }
    }
}
