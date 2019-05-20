package com.designer.single;

/**
 * @author Administrator 2019-02-18 10:22
 * 懒汉式，线程不安全
    是否 Lazy 初始化：是
    是否多线程安全：否
    实现难度：易
    描述：这种方式是最基本的实现方式，
    这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
 **/
public class LazySingleNotSafe {

    private static LazySingleNotSafe lazySingleNotSafe;

    private LazySingleNotSafe(){}

    public static LazySingleNotSafe getLazySingleNotSafe(){
        if (lazySingleNotSafe == null){
            return lazySingleNotSafe;
        }
        return lazySingleNotSafe;
    }
}
