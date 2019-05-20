package com.momo.synchronizedd.wait_notify_notifyall.two;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClas {

    public static void main(String[] args) {
        Handler handler = new Handler();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new Client(handler));
        service.execute(new Server(handler));
        service.shutdown();
    }

}
