package com.momo.lock;

public class Consumer implements Runnable {

    private Resource resource;

    public Consumer(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true){
            resource.out();
        }
    }
}