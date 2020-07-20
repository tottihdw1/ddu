package com.hdw.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author hdw
 * @create 2020-06-12-10:37
 * @desc
 *
 * 一. lambda 表达式的基础语法:
 * java8引入了一个新的操作符 "->"
 * 该操作符为箭头操作符或lambda操作符
 * 箭头操作符将Lambda 表达式中所需执行的功能分成两部分
 * 左侧：Lambda表达式的参数列表
 * 右侧：Lambda表达式中所需执行的功能，即Lambda体
 *
 *  lambda本质是一个语法糖
 * 语法格式一：无参数、无返回值方法
 * （）->   System.out.println("hello ");
 *
 *  语法格式二：有一个参数、无返回值方法
 * （x）->   System.out.println(x);
 *
 *  语法格式三：只有有一个参数、无返回值方法，参数的括号可以省略
 *   x->   System.out.println("hello ");
 *
 *  语法格式四：有两个参数、有返回值方法，并且Lambda体中含有多语句
 *  x->   System.out.println("hello ");
 *
 *  语法格式五：Lambda体只有一条语句 return和大括号都可以不写
 *  Comparator<Integer> com=(x,y)->Integer.compare(x,y);
 *
 *  语法格式六：Lambda表达式的参数列表的数据类型可以省略不写，因为JVM的java编译器可以通过上下文推断出“数据类型”
 *  即 “类型推断”
 *
 * 二
 * lambda 需要“函数式接口”的支持
 * 函数式接口：接口中只有一个抽象接口的接口，称为抽象接口。
 * 可以使用注解 @FunctionalInterface修饰，用来检查是否是函数式接口
 */
public class TestLambda2 {

    /**
     * 语法格式一：无参数、无返回值方法
     */
    @Test
    public void test(){
        int num=0;// jdk1.7及之前 必须是final .jdk1.8 默认加final

        //匿名内部类
      Runnable r=new Runnable() {
          @Override
          public void run() {
              System.out.println("123"+num);
          }
      };
        r.run();
        System.out.println("--------------------------------------");

        // lambda 语法格式一
        Runnable r1=()->  System.out.println("456");
        r1.run();
    }

    /**
     * 语法格式二：有一个参数、无返回值方法
     */
    @Test
    public void test2(){
        Consumer<String> con=(x)-> System.out.println(x);
        con.accept("hellp hdw");
    }

    /**
     * 语法格式四：有两个参数、有返回值方法，并且Lambda体中含有多语句
     */
    @Test
    public void test3(){
        Comparator<Integer> com=(x,y)->{
            System.out.println("语法格式四：有两个参数、有返回值方法，并且Lambda体中含有多语句");
            return Integer.compare(x,y);
        };
        int compare = com.compare(10, 99);
        System.out.println(compare);
    }


    //实现函数式接口
    @Test
    public void test4(){

        Integer dd = operator(100, x -> x + x);
        System.out.println(dd);

    }

    public Integer operator(Integer num,MyFun<Integer> t){

       return t.getValue(num);
    }
}
