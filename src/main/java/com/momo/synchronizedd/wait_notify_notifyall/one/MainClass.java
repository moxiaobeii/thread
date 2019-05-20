package com.momo.synchronizedd.wait_notify_notifyall.one;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {

    public static void main(String[] args) {
        Temp temp = new Temp();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new Waiter(temp));
        service.execute(new Notifyer(temp));
        service.shutdown();
    }
}
