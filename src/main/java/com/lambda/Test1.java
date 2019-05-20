package com.lambda;

import java.util.function.Function;

/**
 * @author Administrator 2019-01-30 11:51
 **/
public class Test1 {

    public static void main(String[] args) {
        Test1 test1 = new Test1();

        //类型声明
        MathOperation addition = (int a,int b) -> a + b;

        //不用类型声明
        MathOperation subtraction = (a,b) -> a - b;

        //大括号中的返回语句
        MathOperation multiplication = (int a ,int b) -> {return a * b;};

        //没有大括号和返回语句
        MathOperation division = (int a,int b) -> a/b;

        System.out.println("10 + 5 = " + test1.operation(10,5,addition));
        System.out.println("10 - 5 = " + test1.operation(10,5,subtraction));
        System.out.println("10 * 5 = " + test1.operation(10,5,multiplication));
        System.out.println("10 / 5 = " + test1.operation(10,5,division));

        //不用括号
        GreetingService greetingService = (message) -> System.out.println("hello" + message);

        greetingService.sayMessage("Runoob");
        greetingService.sayMessage("Google");

        Runnable runnable2 = () -> System.out.println("hdhd");
        new Thread(runnable2);

        Function<Integer,Integer> f1 = it ->{
            int sum = 0;
            for (int i = 0;i < it;i++){
                sum += i;
            }
            return sum;
        };
        System.out.println("f1" + f1.apply(10));

        Runnable runnable = Test1::hello;
        Function<String,String> fa = str -> str.toUpperCase();
        Function<String,String> fb = String::toUpperCase;
        new Thread(runnable);
        System.out.println(fa.apply("dfdfsd"));
        System.out.println(fb.apply("fdfdfd"));

        Function<String,String> function1 = (String str) -> str.toString();
        Function<String,String> function2 = (String str) -> new String("hello").toString();
        Function<String,String> function3 = String::toString;
        System.out.println(function1.apply(new String("World")));
        System.out.println(function2.apply(new String("World")));
        System.out.println(function3.apply(new String("World")));

    }

    public static void hello(){
        System.out.println("say hello");
    }

    interface MathOperation{
        int operation(int a ,int b);
    }
    interface GreetingService{
        void sayMessage(String message);
    }
    private int operation(int a,int b,MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }
}

