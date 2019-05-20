package com.momo.synchronizedd.tortoise;

public abstract class Animal extends Thread{

    public double length = 20;  //比赛的长度

    public abstract void running();  //抽象方法需要子类实现

    //在子类重写run（）方法
    @Override
    public void run() {
        super.run();
        while (length > 0){
            running();
        }
    }

    //在需要回调数据的地方（两个子类需要），声明一个接口
    public static interface Colltoback{
        public void win();
    }

    //创建接口对象
    public Colltoback colltoback;
}
