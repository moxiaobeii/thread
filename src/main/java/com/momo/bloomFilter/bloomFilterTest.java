package com.momo.bloomFilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试分两步：
 一 我们往过滤器里放一百万个数，然后去验证这一百万个数是否能通过过滤器，目的是校验是坏人是否一定被抓。
 二 我们另找1万个不在这一百万范围内的数，去验证漏网之鱼的概率，也就是布隆过滤器的误伤情况。
 */
public class bloomFilterTest {

    public static int size = 1000000;

    private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(),size);

    public static void main(String[] args) {
        for (int i = 0; i < size; i++) {
            bloomFilter.put(i);
        }
        
        for (int i = 0; i < size; i++) {
            if (!bloomFilter.mightContain(i)){
                System.out.println("有坏人逃跑了！");
            }
            
        }

        List<Integer> list = new ArrayList<Integer>(1000);
        for (int i = size+10000; i < size+20000; i++) {
            if (bloomFilter.mightContain(i)){
                list.add(i);
            }
        }

        System.out.println("有误伤的数量： " + list.size());
    }
}
