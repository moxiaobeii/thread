package com.momo.synchronizedd.atm;

public class MainClass {

    public static void main(String[] args) throws InterruptedException {
        //实例化一个一行对象
        Bank bank = new Bank();

        //实例化两个人，传入一个银行的对象
        PersonA personA = new PersonA(bank);
        PersonB personB = new PersonB(bank);

        //两个人开始数钱
        personA.start();
        personB.start();
    }
}
