package com.momo.synchronizedd.tortoise;

public class MainClass {

    public static void main(String[] args) {
        //实例化乌龟和兔子
        Tortoise tortoise = new Tortoise();
        Rabbit rabbit = new Rabbit();

        //回调方法的使用，谁先调用colltoback方法，另一个就不跑了
        LetOneStop letOneStop= new LetOneStop(tortoise);
        rabbit.colltoback = letOneStop;

        LetOneStop letOneStop1 = new LetOneStop(rabbit);
        rabbit.colltoback = letOneStop;

        //开始跑
        rabbit.start();
        tortoise.start();

    }

}
