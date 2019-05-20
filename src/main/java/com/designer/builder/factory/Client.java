package com.designer.builder.factory;

/**
 * @author Administrator 2019-02-15 16:33
 * 使用建造者模式。
 **/
public class Client {

    public static void main(String[] args) {
        testBuilderPattern();
    }

    public static void testBuilderPattern(){
        ConcreteBuilder1 builder1 = new ConcreteBuilder1();   //建造者
        Director director = new Director(builder1);  //监工
        director.construct();     //建造实例（监工负责监督，建设者实际建造）
        String result = builder1.getResult();  //最终生成结果
        System.out.println("the result is :\n" + result);
    }
}
