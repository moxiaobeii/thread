package com.momo.synchronizedd.kfc;

import lombok.Data;

//创建食物类
@Data
public class Food {

    String name = "";

    //通过构造方法传入食物的名字
    public Food(String name){
        this.name = name;
    }

}
