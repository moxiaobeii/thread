package com.momo.other;

import java.util.*;

public class ListTest {

    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();

        map.put("张三1", "男");
        map.put("张三2", "男");
        map.put("张三3", "男");
        map.put("张三4", "男");
        map.put("张三5", "男");

        //第一种遍历
        for (String s:map.keySet()){
            System.out.println("key:" + s + ",value:" + map.get(s));
        }
        System.out.println("============");

        //第二种遍历
        for (Map.Entry<String,String> entry:map.entrySet()) {
            System.out.println("key:" + entry.getKey() + "value:" + entry.getValue());
        }
        System.out.println("=============");

        //第三种遍历
        Iterator<Map.Entry<String,String>> it = map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String,String> entry = it.next();
            System.out.println("key:" + entry.getKey() + "value:" + entry.getValue());
        }

    }
}
