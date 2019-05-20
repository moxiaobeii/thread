package com.momo.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
 */
public class NewFixedThreadPool {

    public static void main(String[] args) {
        //线程池允许同时存在两个线程
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 4; i++) {
            final int index = i;
            service.execute(new ThreadForpools(index));
        }
    }

}
