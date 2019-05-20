package com.momo.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {

    public static void main(String[] args) {

        //第一种方式
        ExecutorService service = Executors.newCachedThreadPool();
        Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        service.submit(futureTask);
        service.shutdown();

        //第二种方式
//        Task task1 = new Task();
//        FutureTask<Integer> futureTask1 = new FutureTask<>(task);
//        Thread thread = new Thread(futureTask1);
//        thread.start();
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程正在执行任务");
        try{
            System.out.println("task运行结果" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("所有任务执行完毕");
    }
}


