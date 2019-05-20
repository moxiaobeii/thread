package com.annotation.define;

/**
 * @author Administrator 2019-02-15 16:04
 **/
@MyAnnotation("haha")
public class AnnotationUse {

    public static void main(String[] args) {
        if (AnnotationUse.class.isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation annotation = AnnotationUse.class.getAnnotation(MyAnnotation.class);
            System.out.println(annotation.color());
            System.out.println(annotation.value());
        }
    }
}
