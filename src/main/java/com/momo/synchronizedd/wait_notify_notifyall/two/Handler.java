package com.momo.synchronizedd.wait_notify_notifyall.two;

public class Handler {

    private boolean isClientRequest = false;

    public void sendRequest(){   //客户端发送请求  （2）
        synchronized (this){
            isClientRequest = true;
            this.notifyAll();
        }
    }

    public void waitResponse() throws InterruptedException {   //等待服务端的响应（3）
        synchronized (this){
            while(isClientRequest){
                this.wait();
            }
        }
    }

    public void receiveRequest(){   //处理客户端请求（）
        synchronized (this){
            isClientRequest = false;
            this.notifyAll();
        }
    }

    public void waitRequest() throws InterruptedException {  //等待客户端请求（1）
        synchronized (this){
            while (!isClientRequest){
                this.wait();
            }
        }
    }

}
