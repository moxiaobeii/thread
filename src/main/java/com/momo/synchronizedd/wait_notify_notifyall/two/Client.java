package com.momo.synchronizedd.wait_notify_notifyall.two;

import java.util.concurrent.TimeUnit;

public class Client implements Runnable {

    private Handler handler;

    public Client(Handler handler){
        this.handler = handler;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            System.out.println("客户端发送请求");
            try {
                TimeUnit.SECONDS.sleep(1);
                handler.sendRequest();  //第二步
                System.out.println("等待服务端的响应");
                handler.waitResponse();  //第三步
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
