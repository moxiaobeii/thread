package com.momo.synchronizedd.method;

public class B implements Runnable {

    private A a;

    public B(A a){
        this.a = a;
    }

    @Override
    public void run() {
        a.b();
    }
}
