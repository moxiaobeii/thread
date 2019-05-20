package com.designer.single;

/**
 * @author Administrator 2019-02-18 10:18
 **/
public class SingleObject {

    private static SingleObject instance = new SingleObject();

    private SingleObject(){}

    //获取唯一可用的对象
    public static SingleObject getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello World");
    }

}
