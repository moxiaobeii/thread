package com.momo.synchronizedd.wait_notify_notifyall.one;

public class Waiter implements Runnable {

    private Temp temp;

    public Waiter(Temp temp){
        this.temp = temp;
    }

    @Override
    public void run() {
        try {
            temp.waiter();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
