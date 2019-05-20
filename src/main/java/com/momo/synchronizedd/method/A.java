package com.momo.synchronizedd.method;

public class A {

    private Object obj = "124";
    public void a(){
        synchronized (obj){
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread()
                 + "a:" + i);
            }
        }
    }
    public void b(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread() + "b:" + i);
        }
    }



}
