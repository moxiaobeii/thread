package com.momo.synchronizedd.tortoise;

public class Rabbit extends Animal{

    public Rabbit(){
        setName("兔子");
    }

    @Override
    public void running() {
        //跑的距离
        double dis = 0.5;
        length -= dis;
        if (length <= 0){
            length = 0;
            System.out.println("兔子获得了胜利");
            //给回调对象赋值，让乌龟不要跑了
            if (colltoback != null){
                colltoback.win();
            }
        }
        System.out.println("兔子跑了" + dis + "米，距离终点还有" + (int)length + "米");

        if (length % 2 == 0){  //两米休息一次
            try {
                System.out.println("兔子跑了2米了，该休息1s了");
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
