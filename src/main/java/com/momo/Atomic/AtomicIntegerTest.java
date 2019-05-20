package com.momo.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  原子更新基恩类型表
 *  源码中for循环体的第一步先取得AtomicInteger里存储的数值，第二步对AtomicInteger的当
    前数值进行加1操作，关键的第三步调用compareAndSet方法来进行原子更新操作，该方法先检
    查当前数值是否等于current，等于意味着AtomicInteger的值没有被其他线程修改过，则将
    AtomicInteger的当前数值更新成next的值，如果不等compareAndSet方法会返回false，程序会进
    入for循环重新进行compareAndSet操作
 */
public class AtomicIntegerTest {

    static AtomicInteger ai = new AtomicInteger(3);

    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());
    }
}
