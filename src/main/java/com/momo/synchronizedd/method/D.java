package com.momo.synchronizedd.method;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class D {

    public static void main(String[] args) {

        A a = new A();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new E((a)));
        executorService.execute(new B(a));
        executorService.execute(new C(a));
        executorService.shutdown();
    }

    /**
     * 按照我们理论这段代码执行顺序是第一个线程和第二个线程无序，
     * 第三个线程必须等待第一个线程执行完毕才可以，测试结果也论证了
     * 我们的理论
     */
}
