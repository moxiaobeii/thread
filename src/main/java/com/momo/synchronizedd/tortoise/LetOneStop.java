package com.momo.synchronizedd.tortoise;

//创建一个让动物停止的类
public class LetOneStop implements Animal.Colltoback{

    //动物对象
    Animal animal;

    //获得动物对象
    public LetOneStop(Animal animal){
        this.animal = animal;
    }

    //让动物的线程停止
    @Override
    public void win() {
        //线程停止
        animal.stop();
    }
}
