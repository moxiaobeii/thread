package com.momo.ConcurrentHashMap;

import java.util.HashMap;
import java.util.UUID;

/**
 * HashMap在并发执行put操作时会引起死循环，是因为多线程会导致HashMap的Entry链表
    形成环形数据结构，一旦形成环形数据结构，Entry的next节点永远不为空，就会产生死循环获
    取Entry。
 */
public class HashMapTest {

    final HashMap<String,String> map = new HashMap<String,String>(2);

    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        map.put(UUID.randomUUID().toString(),"");
                    }
                },"fif" + i).start();
            }
        }
    },"ftf");

    public static void main(String[] args) {
        HashMapTest test = new HashMapTest();
        test.t.start();
    }

}
