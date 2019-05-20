package com.momo.Atomic;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 原子更新字段类
 * 要想原子地更新字段类需要两步。
 * 第一步，因为原子更新字段类都是抽象类，每次使用的
     时候必须使用静态方法newUpdater()创建一个更新器，
     并且需要设置想要更新的类和属性。
   第二步，更新类的字段（属性）必须使用public volatile修饰符
 */
public class AtomicIntegerFieldUpdaterTest {

    //创建原子更新类，并设置需要更新的对象类和对象的属性
    private static AtomicIntegerFieldUpdater<User> a =
            AtomicIntegerFieldUpdater.newUpdater(User.class,"old");

    public static void main(String[] args) {
        //设置柯南的年龄为10岁
        User conan = new User("conan",10);
        //柯南长了一岁，但是仍然会输出旧的年龄
        System.out.println(a.getAndIncrement(conan));
        //输出柯南现在的年龄
        System.out.println(a.get(conan));
    }


    @Data
    @AllArgsConstructor
    public static class User {
        private String name;
        public volatile int old;
    }
}
