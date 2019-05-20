package com.momo.synchronizedd.method;

public class C implements Runnable{

    private A a;

    public C(A a){
        this.a = a;
    }

    @Override
    public void run() {
        a.a();
    }

}
