package com.momo.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 创建一个定长线程池，支持定时及周期性任务执行
 */
public class NewScheduledThreadPool {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        for (int i = 0; i < 4; i++) {
            final  int index = i;
            service.schedule(new ThreadForpools(index),3, TimeUnit.SECONDS);
        }
    }

}
