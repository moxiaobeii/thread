package com.momo.executors;

public class ThreadForpools implements Runnable{

    private Integer index;

    public ThreadForpools(Integer index){
        this.index = index;
    }

    @Override
    public void run() {
        //省略业务
        System.out.println("开始执行线程！！！");
        try {
            Thread.sleep(index * 100);
            System.out.println("我的线程标识是：" + this.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
