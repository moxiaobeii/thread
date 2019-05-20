package com.momo.synchronizedd.method;

public class E implements Runnable {

    private A a;

    public E(A a){
        this.a = a;
    }

    @Override
    public void run() {
        a.a();
    }

}
