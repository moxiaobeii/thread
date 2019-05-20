package com.designer.single;

/**
 * @author Administrator 2019-02-18 10:20
 **/
public class SingletonPatternDemo {

    public static void main(String[] args) {
        /**
         * 不合法的构造函数
         * 编译时错误：构造函数SingleObject()是不可见的
         */
//      SingleObject singleObject = new SingleObject();

        //获取唯一可用的对象
        SingleObject singleObject = SingleObject.getInstance();

        //显示消息
        singleObject.showMessage();
    }

}
