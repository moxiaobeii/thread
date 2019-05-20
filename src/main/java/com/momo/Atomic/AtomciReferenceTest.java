package com.momo.Atomic;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子更新引用类型
 * 代码中首先构建一个user对象，然后把user对象设置进AtomicReferenc中，最后调用
 compareAndSet方法进行原子更新操作，实现原理同AtomicInteger里的compareAndSet方法
 */
public class AtomciReferenceTest {

    public static AtomicReference<User> ai = new AtomicReference<>();

    public static void main(String[] args) {
        User user = new User("conan",15);
        ai.set(user);
        User updateUser = new User("Shinchi",17);
        ai.compareAndSet(user,updateUser);
        System.out.println(ai.get().getName());
        System.out.println(ai.get().getOld());
    }

    @Data
    @AllArgsConstructor
    private static class User {
        private String name;
        private int old;

    }
}
