package com.momo.synchronizedd.wait_notify_notifyall.two;

import java.util.concurrent.TimeUnit;

public class Server implements Runnable {

    public Handler handler;

    public Server(Handler handler){
        this.handler = handler;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            System.out.println("等待客户端请求");
            try {
                handler.waitRequest();  //第一步
                System.out.println("处理客户端请求");
                TimeUnit.SECONDS.sleep(1);  //让出线程
                handler.receiveRequest();  //第四步
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
