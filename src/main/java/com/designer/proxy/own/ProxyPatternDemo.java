package com.designer.proxy.own;

/**
 * @author Administrator 2019-02-18 11:23
 **/
public class ProxyPatternDemo {

    public static void main(String[] args) {
        Image image = new ProxyImage("test.jpg");

        //图像将  从磁盘加载
        image.display();
        System.out.println("");
        //图像不需要从磁盘加载
        image.display();
    }
}
