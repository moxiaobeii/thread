package com.momo.lock;

public class Produce implements Runnable{

    private Resource resource;

    public Produce(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true){
            resource.set("烤鸭");
        }
    }
}
