package com.face;

import java.util.Arrays;
import java.util.List;

public class OutClass {

    static class InnerClass{
        static int paramOne = 4;
        static final int paramTwo = 4;
        static final int paramThree = new Integer(4);
    }

    public static void  first(){
        int j = 0;
        for (int i = 0; i < 100; i++){
            j = j ++;  //0
            j = ++ j;  //100
        }
        System.out.println(j);
    }

    public static void arrray(){
        int [] test = new int[]{1,2,3,4};
        List list = Arrays.asList(test);
        System.out.println(list.size());
        System.out.println(list);
    }

    public static void main(String[] args) {
        System.out.println(InnerClass.paramOne);  //4
        System.out.println(InnerClass.paramTwo); //4
        System.out.println(InnerClass.paramThree);  //4
        first();
        arrray();
    }
}
