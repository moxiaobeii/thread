package com.designer.builder.factory;

/**
 * @author Administrator 2019-02-15 16:26
 * 监工角色：定义使用建造者角色中的方法来生成实例的方法；
 **/
public class Director {  //将一个复杂的构建过程与其表示相分离

    private Builder builder;  //针对接口编程，而不是针对实现编程

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public void construct(){   //控制一个复杂的构建过程
        builder.bulidPart1();
        for (int i = 0; i < 5; i++) {
            builder.bulidPart2();
        }
        builder.bulidPart3();
    }

}
