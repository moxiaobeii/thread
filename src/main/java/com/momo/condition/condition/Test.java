package com.momo.condition.condition;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    private int queueSize = 10;

    private PriorityQueue<Integer> queue= new PriorityQueue<Integer>(queueSize);

    private Lock lock = new ReentrantLock();

    private Condition notFull = lock.newCondition();
    private Condition notNull = lock.newCondition();

    public static void main(String[] args) {
        Test test = new Test();
        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();

        producer.start();
        consumer.start();
    }

    class Consumer extends Thread{
        @Override
        public void run() {
            consume();
        }

        private void consume() {
            while (true){
                lock.lock();
                try {
                    while (queue.size() == 0) {
                        try {
                            System.out.println("队列空，等待数据");
                            notNull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();  //每次移走一个数据
                    notFull.signal();
                    System.out.println("从队列取走一个元素，队列还剩下" + queue.size() + "个元素");
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    class Producer extends Thread{
        @Override
        public void run() {
            produce();
        }

        private void produce() {
            while (true){
                lock.lock();
                try{
                    while (queue.size() == queueSize){
                        try{
                            System.out.println("队列满，等待有空余空间");
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.offer(1);  //每次插入一个数据
                    notNull.signal();
                    System.out.println("向队列中插入一个元素，队列剩余空间" + (queueSize-queue.size()));
                }finally {
                    lock.unlock();
                }
            }
        }
    }

}
