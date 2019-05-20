package com.designer.builder.factory;

/**
 * @author Administrator 2019-02-15 16:30
 * 具体的建造者角色：实现生成实例所需要的所有方法，并且定义获取最终生成实例的方法；
 * 此处实现了建造纯文本文档的具体建造者。
 * 可以考虑再实现一个建造HTML文档、XML文档，或者其它什么文档的具体建造者。
 * 这样，就可以使得同样的构建过程可以创建不同的表示
 **/
public class ConcreteBuilder1 extends Builder{

    private StringBuffer buffer = new StringBuffer();

    @Override
    public void bulidPart1() {
        buffer.append("Builder1:Part1\n");
    }

    @Override
    public void bulidPart2() {
        buffer.append("Builder2:Part2\n");
    }

    @Override
    public void bulidPart3() {
        buffer.append("Builder3:Part3\n");
    }

    //定义获取最终生成实例的方法
    public String getResult() {
        return buffer.toString();
    }
}
