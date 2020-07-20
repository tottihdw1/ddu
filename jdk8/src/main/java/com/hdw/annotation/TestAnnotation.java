package com.hdw.annotation;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author hdw
 * @create 2020-06-23-15:21
 * @desc 描述
 */
public class TestAnnotation {

    /**
     * 重复注解
     */
    @MyAnnotation("hello")
    @MyAnnotation("world")
    public  void show(@MyAnnotation("123")  String s){

    }


    @Test
    public void test(){
        Class<TestAnnotation> clazz=TestAnnotation.class;
        try {
            Method method = clazz.getMethod("show");
            MyAnnotation[] type = method.getAnnotationsByType(MyAnnotation.class);
            for (MyAnnotation my : type) {
                System.out.println(my.value());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
