package com.momo.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个可缓存线程池，应用中存在的线程数可以无限大
 */
public class NewCashedThreadPool {

    /**
     * 我们获取四次次线程，观察4个线程地址
     * @param args
     */
    public static void main(String[] args) {
        //(1)创建一个可缓存线程池，应用中存在的线程数可以无限大
        ExecutorService newCashedThreadPool = Executors.newCachedThreadPool();
        System.out.println("----------newCashedThreadPool-------------");
        for (int i = 0; i < 4; i++) {
            final int index = i;
            newCashedThreadPool.execute(new ThreadForpools(index));
        }
    }

}
