package com.momo.synchronizedd.wait_notify_notifyall.one;

public class Notifyer implements Runnable {

    private Temp temp;

    public Notifyer(Temp temp){
        this.temp = temp;
    }

    @Override
    public void run() {
        try {
            temp.notifyer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
