package com.momo.condition.synchronizedd;

import java.util.PriorityQueue;

public class Test {

    private int queueSize = 10;

    private PriorityQueue<Integer> queue = new PriorityQueue<>(queueSize);

    public static void main(String[] args) {
        Test test = new Test();
        Produce produce = test.new Produce();
        Consumer consumer = test.new Consumer();

        produce.start();
        consumer.start();
    }

    private class Produce extends Thread{
        @Override
        public void run() {
            produce();
        }
        private void produce(){
            while(true){
                synchronized (queue){
                    while (queue.size() == queueSize){
                        try{
                            System.out.println("队列满，等待有空余空间");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.offer(1);   //每次插入一个数据
                    queue.notify();
                    System.out.println("向队列中插入一个元素，队列剩余空间" + (queueSize-queue.size()));
                }
            }
        }
    }
    private class Consumer extends Thread{
        @Override
        public void run() {
            consume();
        }

        private void consume(){
            while (true){
                synchronized (queue){
                    while (queue.size() == 0){
                        try {
                            System.out.println("队列空等待数据");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    //队列部位空
                    queue.poll();   //每次移走队首元素
                    queue.notify();
                    System.out.println("从队列取走一个元素，队列剩余" + queue.size() + "个元素");
                }
            }
        }
    }
}
