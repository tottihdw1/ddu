package com.hdw.stream;

import com.hdw.lambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * @author hdw
 * @create 2020-06-15-13:48
 * @desc 描述
 *
 *
 * Stream 的三个步骤
 * 1.创建
 * 2.中间操作
 * 3.终止操作（终端操作）
 *
 *
 *
 *
 */
public class TestStreamApi1 {

    //创建
    @Test
    public void test(){
        //1. 可以通过Collection 系列集合提供的stream()或者paralleStream()
        ArrayList<String> list=new ArrayList<>();
        Stream <String> s1 = list.stream();

        //2. 通过Arrays 中的静态方法stream(),获取数组流
        Employee[] emps=new Employee[10];
        Stream <Employee> s2 = Arrays.stream(emps);

        //3.通过Stream类中的静态方法 of()
        Stream <Employee> s3 = Stream.of(emps);

        //4.创建无限流
        //迭代
        Stream <Integer> iterate = Stream.iterate(0, (x) -> x + 2);
        iterate.limit(10).forEach(System.out::println);

        //生成
        Stream <Double> generate = Stream.generate(() -> Math.random() * 10);
        generate.limit(5).forEach(System.out::println);


    }
}
